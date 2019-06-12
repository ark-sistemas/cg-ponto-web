package br.com.senai.fatesg.controleponto.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.controleponto.entidade.JornadaTrabalho;
import br.com.senai.fatesg.controleponto.entidade.JustificativaAbono;
import br.com.senai.fatesg.controleponto.persistencia.JornadaTrabalhoDao;


//@Scope("conversation")
//@Named("JornadaTrabalhoControl")
//@ViewScoped
public class JornadaTrabalhoControlAndrezza {
	

	private JornadaTrabalho jornadaTrabalho = new JornadaTrabalho();
	
	@Autowired
	private JornadaTrabalhoDao jornadaTrabalhoDao;

	private List<JornadaTrabalho> jornadasTrabalhos = new ArrayList<JornadaTrabalho>();

	private List<String> jornadas = new ArrayList<String>();
	private String jornada;

	@PostConstruct
	public void init() {		
		preencherJornadas();
		listar(null);
	}		
	
	private void preencherJornadas() {
		// TODO Auto-generated method stub
		jornadasTrabalhos = jornadaTrabalhoDao.listar();
		for (int i = 0; i < jornadasTrabalhos.size(); i++) {
			if(!jornadasTrabalhos.isEmpty()) {
				jornadas.add(jornadasTrabalhos.get(i).getDescricao());
			}				
		}
	}
	
	public void confirmar(ActionEvent evt) {
		try {
			jornadaTrabalho.mostraDias();
			jornadaTrabalhoDao.alterar(jornadaTrabalho);
			listar(evt);
			jornadaTrabalho = new JornadaTrabalho();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void confirmarTeste(JornadaTrabalho jornada) {
		try {
			jornadaTrabalho.mostraDias();
			jornadaTrabalhoDao.alterar(jornada);
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void incluirJornada(JornadaTrabalho jornada) {
		try {
			System.out.println("Jornada é: "+ jornada.getDescricao());
			jornadaTrabalhoDao.incluir(jornada);
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e.getLocalizedMessage());
		}
	}
	
	public void alterar(JornadaTrabalho jornada) {
		try {
			System.out.println("Jornada é: "+ jornada.getDescricao());
			jornadaTrabalhoDao.alterar(jornada);
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e.getLocalizedMessage());
		}
	}
	
	public JornadaTrabalho consultar(JornadaTrabalho jornada) {
		try {
			return jornadaTrabalho = jornadaTrabalhoDao.consultar(jornada);
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
		return jornadaTrabalho;
	}
	
	public void excluir(ActionEvent evt) {
		try {
			jornadaTrabalhoDao.excluirPorId(jornadaTrabalho.getId());
			listar(evt);
			jornadaTrabalho = new JornadaTrabalho();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void excluir(JornadaTrabalho jornada) {
		try {
			jornadaTrabalhoDao.excluirPorId(jornada.getId());
			jornadasTrabalhos = jornadaTrabalhoDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void listar(ActionEvent evt) {
		try {
			jornadasTrabalhos = jornadaTrabalhoDao.listar();
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void onRowSelect(SelectEvent event) {
		this.jornadaTrabalho = ((JornadaTrabalho) event.getObject());
		FacesMessage msg = new FacesMessage("Jornada Marcada", ((JornadaTrabalho) event.getObject()).getDescricao());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		this.jornadaTrabalho = null;
		FacesMessage msg = new FacesMessage("Jornada Desmarcada", ((JornadaTrabalho) event.getObject()).getDescricao());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<JornadaTrabalho> listAutoComplete() {
		try {
			return 	jornadasTrabalhos = jornadaTrabalhoDao.listar();
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
		return jornadasTrabalhos;
	}
	
	public List<String> getJornadas() {
		return jornadas;
	}

	public void setJornadas(List<String> jornadas) {
		this.jornadas = jornadas;
	}

	public JornadaTrabalho getJornadaTrabalho() {
		return jornadaTrabalho;
	}

	public void setJornadaTrabalho(JornadaTrabalho jornadaTrabalho) {
		this.jornadaTrabalho = jornadaTrabalho;
	}

	public List<JornadaTrabalho> getJornadaTrabalhos() {
		return jornadasTrabalhos;
	}
	// tst
	
	public List<JornadaTrabalho> getJornadasTrabalhos() {
		return jornadasTrabalhos;
	}

	public void setJornadasTrabalhos(List<JornadaTrabalho> jornadasTrabalhos) {
		this.jornadasTrabalhos = jornadasTrabalhos;
	}	
}
