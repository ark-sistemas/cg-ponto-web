package br.com.senai.fatesg.controleponto.controle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.controleponto.entidade.Funcionario;
import br.com.senai.fatesg.controleponto.entidade.JustificativaAbono;
import br.com.senai.fatesg.controleponto.entidade.Usuario;
import br.com.senai.fatesg.controleponto.persistencia.FuncionarioDao;
import br.com.senai.fatesg.controleponto.persistencia.JustificativaAbonoDao;

//@Scope("conversation")
//@SessionScoped
//@ViewScoped
@RequestScoped
@Named("JustificativaAbonoControl")
public class JustificativaAbonoControl {
	
	private Funcionario funcionario = new Funcionario();
	private JustificativaAbono justificativaAbono = new JustificativaAbono();
	private JustificativaAbono justificativa = new JustificativaAbono();
	private Part arquivo;
	@Autowired
	private JustificativaAbonoDao justificativaAbonoDao;
	@Autowired
	private FuncionarioDao funcionarioDao;
	 
	private List<JustificativaAbono> justificativaAbonos = new ArrayList<JustificativaAbono>();
	private List<JustificativaAbono> justificativaAbonosRH = new ArrayList<JustificativaAbono>();
	private List<JustificativaAbono> justificativaAux = new ArrayList<JustificativaAbono>();
	private List<Funcionario> listFuncionario = new ArrayList<Funcionario>();
	  
	@PostConstruct
	   public void init(){
		justificativa = new JustificativaAbono();
		listarUser();
		listar(null);
	   }
	
	public void buscarJustificativa(ActionEvent evt) {
		justificativaAbonos = justificativaAbonoDao.listar();
		
	}
	public void incluir(ActionEvent evt){
		try {
			Usuario usuarioLogado = UsuarioLogadoControl.getUsuarioLogado();
			justificativa.setUsuarioLogado(usuarioLogado);
			justificativaAbonoDao.incluir(justificativa);
			listarUser();
         justificativaAbono = new JustificativaAbono();
		} catch (Exception e) {
		   UtilFaces.addMensagemFaces(e);
		}
	}
	public void alterar() {
		try {
			//UsuarioLogadoControl usuario = new UsuarioLogadoControl();
			//Usuario user = usuario.getUsuarioLogado();
			Usuario usuarioLogado = UsuarioLogadoControl.getUsuarioLogado();
			listFuncionario = funcionarioDao.listar();
			for(Funcionario funcionarioAux : listFuncionario) {
				if(funcionarioAux.getNome().equals(usuarioLogado.getNome())) {
					funcionario = funcionarioAux;
				}
			}
			upload();
			justificativa.setUsuarioLogado(usuarioLogado);
			justificativa.setStatus("Recusado");
			justificativaAux.add(justificativa);
			funcionario.setJustificativasAbonos(justificativaAux);
			funcionarioDao.alterar(funcionario);
			listarUser();
			justificativa = new JustificativaAbono(); 
			//criar/chamar um metodo que grava o abono no registro de ponto
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void excluir(JustificativaAbono abono) {
		try {
			justificativaAbonoDao.excluirPorId(abono.getIdJustificativa());
			justificativa = new JustificativaAbono();
			justificativaAbonos = justificativaAbonoDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void download(JustificativaAbono abono) throws IOException {
		System.out.println("Aqui "+abono.getDescricao());
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.
				getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-Disposition", "attachment; filename=download.pdf");
		response.setContentType("application/octet-stream");
		response.setContentLength(abono.getAnexoDocumento().length);
		response.getOutputStream().write(abono.getAnexoDocumento());
		response.getOutputStream().flush();
		FacesContext.getCurrentInstance().responseComplete();
		
		
	}
	
	public void upload() {
		try {
			byte[] arquivoByte = toByteArrayUsingJava(arquivo.getInputStream());
			//byte[] arquivoByte = BytesUtilJalis.toByteArray(arquivo.getInputStream());
			justificativa.setAnexoDocumento(arquivoByte);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public byte[] toByteArrayUsingJava(InputStream is) throws IOException {
		ByteArrayOutputStream boas = new ByteArrayOutputStream();
		int read = is.read();
		while (read != -1) {
			boas.write(read);
			read = is.read();
		}
		return boas.toByteArray();
	}
	@Transactional
	public void listar(ActionEvent evt){
		try {
			justificativaAbonosRH = justificativaAbonoDao.listar();
		} catch (Exception e) {
		   UtilFaces.addMensagemFaces(e);
		}
	}
	@Transactional
	public void listarUser(){
		try {
			Usuario usuarioLogado = UsuarioLogadoControl.getUsuarioLogado();
			if(usuarioLogado != null) {
				
				for(JustificativaAbono justificativa : justificativaAbonoDao.listar()) {
					if(justificativa.getUsuarioLogado().getNome().equals(usuarioLogado.getNome())) {
						
						justificativaAbonos.add(justificativa);
					}
				}
			}
		} catch (Exception e) {
		   UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void onRowSelect(SelectEvent event) {
		this.justificativa = ((JustificativaAbono) event.getObject());
		FacesMessage msg = new FacesMessage("Jutificativa Marcada", ((JustificativaAbono) event.getObject()).getDescricao());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		this.justificativa = null;
		FacesMessage msg = new FacesMessage("Jutificativa Desmarcada", ((JustificativaAbono) event.getObject()).getDescricao());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<JustificativaAbono> getJustificativaAbonosRH() {
		return justificativaAbonosRH;
	}

	public void setJustificativaAbonosRH(List<JustificativaAbono> justificativaAbonosRH) {
		this.justificativaAbonosRH = justificativaAbonosRH;
	}

	public List<JustificativaAbono> getJustificativaAux() {
		return justificativaAux;
	}

	public void setJustificativaAux(List<JustificativaAbono> justificativaAux) {
		this.justificativaAux = justificativaAux;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Part getArquivo() {
		return arquivo;
	}

	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}
			
	public JustificativaAbono getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(JustificativaAbono justificativa) {
		this.justificativa = justificativa;
	}

	public JustificativaAbono getJustificativaAbono() {
		return justificativaAbono;
	}

	public void setJustificativaAbono(JustificativaAbono justificativaAbono) {
		this.justificativaAbono = justificativaAbono;
	}

	public List<JustificativaAbono> getJustificativaAbonos() {
		return justificativaAbonos;
	}

	public JustificativaAbonoDao getJustificativaAbonoDao() {
		return justificativaAbonoDao;
	}

	public void setJustificativaAbonoDao(JustificativaAbonoDao justificativaAbonoDao) {
		this.justificativaAbonoDao = justificativaAbonoDao;
	}

	public void setJustificativaAbonos(List<JustificativaAbono> justificativaAbonos) {
		this.justificativaAbonos = justificativaAbonos;
	}
	
	

//	public static Usuario getUsuarioLogado() {
//		return (Usuario) UtilFaces.getObjetoManagedBean("#{UsuarioLogadoControl.usuario}");
//	}
}
