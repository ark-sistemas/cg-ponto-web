package br.com.senai.fatesg.controleponto.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.controleponto.entidade.Empresa;
import br.com.senai.fatesg.controleponto.persistencia.EmpresaDao;

@Named("EmpresaControl")
@Scope(value = "session")
public class EmpresaControl{
	
	private Empresa empresa = new Empresa();
	private Empresa empresaAux = new Empresa();
	
	@Autowired
	private EmpresaDao empresaDao;
	
	private List<Empresa> empresas = new ArrayList<>();
	
	@PostConstruct
	public void init(){
	   listar(null);
	}
	
	public void confirmar(ActionEvent event) {
		try {
			empresaDao.alterar(empresa);
			listar(event);
			empresa = new Empresa();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void excluir(Empresa emp) {
		try {
			empresaDao.excluirPorId(emp.getId());
			empresa = new Empresa();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void listar(ActionEvent event) {
		try {
			empresas = empresaDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void onRowSelect(SelectEvent event) {
			this.empresa = ((Empresa) event.getObject());
			FacesMessage msg = new FacesMessage("Empresa Marcada", ((Empresa) event.getObject()).getNomeFantasia());
			FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onRowUnselect(UnselectEvent event) {
		this.empresa = null;
        FacesMessage msg = new FacesMessage("Empresa Desmarcada", ((Empresa) event.getObject()).getNomeFantasia());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public Empresa getEmpresaAux() {
		return empresaAux;
	}

	public void setEmpresaAux(Empresa empresaAux) {
		this.empresaAux = empresaAux;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	
}
