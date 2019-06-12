package br.com.senai.fatesg.controleponto.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.controleponto.entidade.Funcionario;
import br.com.senai.fatesg.controleponto.entidade.RegistroPonto;
import br.com.senai.fatesg.controleponto.persistencia.AjusteDeRegistroDao;
import br.com.senai.fatesg.controleponto.persistencia.FuncionarioDao;

@Named("AjusteDeRegistroControl")
@Scope("conversation")
public class RegistroPontoControl {
	
	private RegistroPonto ajusteDeRegistro = new RegistroPonto();
	private Funcionario funcionario = new Funcionario();
	@Autowired
	private AjusteDeRegistroDao ajusteDeRegistroDao;
	@Autowired
	private FuncionarioDao funcionarioDao;
	
	private List<RegistroPonto> ajusteDeRegistros = new ArrayList<RegistroPonto>();
	 private static final Map<Long, RegistroPonto> registroMap = new HashMap<Long, RegistroPonto>();
	@PostConstruct
	public void init() {
		listar(null);
	}
	
		
	public void confirmar(ActionEvent evt) {
		try {
			ajusteDeRegistroDao.alterar(ajusteDeRegistro);
			listar(evt);
			ajusteDeRegistro = new RegistroPonto();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void atualizar() {
		try {
			ajusteDeRegistroDao.getEntityManager().createNamedQuery("");
			ajusteDeRegistro = new RegistroPonto();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void listarAutoComplete() {
		ajusteDeRegistros.clear();
		try {
			for(RegistroPonto aux : ajusteDeRegistroDao.listar()) {
				if(this.funcionario.getEmail() == aux.getEmail()) {
					this.ajusteDeRegistros.add(aux);
					System.out.println(aux.getIdcodigoJornadaTrabalho()+" ID");
				}
//				if(this.funcionario.getId().longValue() == aux.getIdFuncionario()) {
//					this.ajusteDeRegistros.add(aux);
//					System.out.println(aux.getIdcodigoJornadaTrabalho()+" ID");
//				}
			}
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void listar(ActionEvent evt) {
		try {
			this.ajusteDeRegistros = ajusteDeRegistroDao.listar();
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}	
	
	public void listarPorId(int id) {
		try {
			setAjusteDeRegistros(ajusteDeRegistroDao.listar(id));
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
	}
	
	public List<Funcionario> autoComplete(String query) {
		List<Funcionario> lista = funcionarioDao.listar();
		List<Funcionario> filtLista = new ArrayList<Funcionario>();
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
			Funcionario skin = lista.get(i);
			if (skin.getNome().toLowerCase().contains(query)) {
				filtLista.add(skin);
			}
		}
		
		return filtLista;
		
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public List<RegistroPonto> getAjusteDeRegistros() {
		return ajusteDeRegistros;
	}

	public void setAjusteDeRegistros(List<RegistroPonto> ajusteDeRegistros) {
		this.ajusteDeRegistros = ajusteDeRegistros;
	}

	public RegistroPonto getAjusteDeRegistro() {
		return ajusteDeRegistro;
	}

	public void setAjusteDeRegistro(RegistroPonto ajusteDeRegistro) {
		this.ajusteDeRegistro = ajusteDeRegistro;
	}

	public AjusteDeRegistroDao getAjusteDeRegistroDao() {
		return ajusteDeRegistroDao;
	}

	public void setAjusteDeRegistroDao(AjusteDeRegistroDao ajusteDeRegistroDao) {
		this.ajusteDeRegistroDao = ajusteDeRegistroDao;
	}

	public static Map<Long, RegistroPonto> getRegistromap() {
		return registroMap;
	}
	
	
}
