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
import br.com.senai.fatesg.controleponto.entidade.Funcionario;
import br.com.senai.fatesg.controleponto.entidade.JornadaTrabalho;
import br.com.senai.fatesg.controleponto.persistencia.FuncionarioDao;
import br.com.senai.fatesg.controleponto.persistencia.JornadaTrabalhoDao;
import br.com.senai.fatesg.controleponto.util.ValidadorCPF;

//@Scope("conversation")
//@Scope(value = "session")
@Named("FuncionarioControl")
//@SessionScoped
@ViewScoped
public class FuncionarioControl {

	private Funcionario funcionario = new Funcionario();

	@Autowired
	private FuncionarioDao funcionarioDao;
	@Autowired
	private JornadaTrabalhoDao jornadaTrabalhoDao;

	private List<JornadaTrabalho> jornadasTrabalhos = new ArrayList<JornadaTrabalho>();
	private JornadaTrabalho jornadaTrabalho = new JornadaTrabalho();
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private List<String> funcionariosMotivoAbono = new ArrayList<String>();

	@PostConstruct
	public void init() {
		//jornadaTrabalho = new JornadaTrabalho();
		preencherFuncionarios();
		preencherJornadas();
		listar(null);
	}

	private void preencherFuncionarios() {
		funcionarios = funcionarioDao.listar();
		for (int i = 0; i < funcionarios.size(); i++) {
			if (!funcionarios.isEmpty()) {
				funcionariosMotivoAbono.add(funcionarios.get(i).getNome());
			}

		}
	}
	
	private void preencherJornadas() {
		this.jornadasTrabalhos = jornadaTrabalhoDao.listar();
		/*
		for (int i = 0; i < jornadasTrabalhos.size(); i++) {
			if (!funcionarios.isEmpty()) {
				funcionariosMotivoAbono.add(funcionarios.get(i).getNome());
			}

		}
		*/
	}
	
	
	public void confirmar(ActionEvent evt) {
		try {
			if(ValidadorCPF.isCPF(funcionario.getCpf())) {
				funcionarioDao.alterar(funcionario);
				listar(evt);
				funcionario = new Funcionario();
				
			}
			else {
				
			}
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void excluir(Funcionario func) {
		try {
			funcionarioDao.excluirPorId(func.getId());
			funcionario = new Funcionario();
			funcionarios = funcionarioDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listar(ActionEvent evt) {
		try {
			funcionarios = funcionarioDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void onRowSelect(SelectEvent event) {
		this.funcionario = ((Funcionario) event.getObject());
		FacesMessage msg = new FacesMessage("Empresa Marcada", ((Funcionario) event.getObject()).getNome());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		this.funcionario = null;
		FacesMessage msg = new FacesMessage("Empresa Desmarcada", ((Funcionario) event.getObject()).getNome());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public FuncionarioDao getFuncionarioDao() {
		return funcionarioDao;
	}

	public void setFuncionarioDao(FuncionarioDao funcionarioDao) {
		this.funcionarioDao = funcionarioDao;
	}

	public JornadaTrabalhoDao getJornadaTrabalhoDao() {
		return jornadaTrabalhoDao;
	}

	public void setJornadaTrabalhoDao(JornadaTrabalhoDao jornadaTrabalhoDao) {
		this.jornadaTrabalhoDao = jornadaTrabalhoDao;
	}

	public List<JornadaTrabalho> getJornadasTrabalhos() {
		return jornadasTrabalhos;
	}

	public void setJornadasTrabalhos(List<JornadaTrabalho> jornadasTrabalhos) {
		this.jornadasTrabalhos = jornadasTrabalhos;
	}

	public List<String> getFuncionariosMotivoAbono() {
		return funcionariosMotivoAbono;
	}

	public void setFuncionariosMotivoAbono(List<String> funcionariosMotivoAbono) {
		this.funcionariosMotivoAbono = funcionariosMotivoAbono;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public JornadaTrabalho getJornadaTrabalho() {
		return jornadaTrabalho;
	}

	public void setJornadaTrabalho(JornadaTrabalho jornadaTrabalho) {
		this.jornadaTrabalho = jornadaTrabalho;
	}
	
	
}
