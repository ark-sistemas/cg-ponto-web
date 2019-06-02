package br.com.senai.fatesg.controleponto.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.senai.fatesg.controleponto.entidade.JornadaTrabalho;
import br.com.senai.fatesg.controleponto.entidade.PapelUsuario;

//@FacesConverter("jornadaConvert")
@FacesConverter(forClass = PapelUsuario.class)
public class PapelConverter implements Converter {
		//JornadaTrabalhoControl serv = new JornadaTrabalhoControl();
	    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
	    	
	        if(value != null && !value.isEmpty()) {
	        	return (PapelUsuario) uic.getAttributes().get(value);
	        	
	        }
	        return null;
	    }

	    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
	    	if(object instanceof PapelUsuario) {
	    		PapelUsuario obj = (PapelUsuario) object;
	    		if(obj != null && obj instanceof PapelUsuario && obj.getId() != null) {
	    			uic.getAttributes().put(obj.getId().toString(), obj);
	    			return obj.getId().toString();
	    		}
	    	}
	    	return "";
	    } 
}
