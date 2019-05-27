package br.com.senai.fatesg.controleponto.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senai.fatesg.controleponto.controle.FuncionarioControl;
import br.com.senai.fatesg.controleponto.entidade.Funcionario;
import br.com.senai.fatesg.controleponto.persistencia.FuncionarioDao;

//@FacesConverter(forClass = Funcionario.class)
@FacesConverter("funcionarioConvert")
public class FuncionarioConverter implements Converter {
	@Autowired
	private FuncionarioDao funcionarioDao;
	private FuncionarioControl serv;
	    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
	        if(value != null && !value.isEmpty()) {
	        	Funcionario aux = new Funcionario();
	        	
	        	FuncionarioControl service = (FuncionarioControl) fc.getExternalContext().getApplicationMap().get("FuncionarioControl");
	        	//Funcionario fun = (Funcionario) funcionarioDao.getEntityManager().find(Funcionario.class, Long.parseLong(value));
//	        	List<Funcionario> lista = serv.listas();
//	        	for (int i = 0; i < lista.size(); i++) {
//	        		Funcionario skin = lista.get(i);
//        			if (skin.getId() == Integer.parseInt(value)) {
//        				
//        				return skin;
//        			}
//        			
//        		}
	        	
	        	return (Funcionario) uic.getAttributes().get(value);
//	        	for(Funcionario funcionario :funcionarioDao.listar()) {
//	        		if(funcionario.getId() == Integer.parseInt(value)) {
//	        			return funcionario;
//	        		}
//	        	}
	        	
	        	//aux = (Funcionario) funcionarioDao.getEntityManager().createQuery("select from "+ Funcionario.class.getName()+" where id = "+value).getSingleResult();
	        	
	        	
	        	
	        }
	        return null;
	    }

	    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
	    	if(object instanceof Funcionario) {
	    		Funcionario obj = (Funcionario) object;
	    		if(obj != null && obj instanceof Funcionario && obj.getId() != null) {
	    			uic.getAttributes().put(obj.getId().toString(), obj);
	    			return obj.getId().toString();
	    		}
	    	}
	    	return "";
	    } 
}
