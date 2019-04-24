package br.com.senai.fatesg.controleponto.converter;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.senai.fatesg.controleponto.controle.JornadaTrabalhoControl;
import br.com.senai.fatesg.controleponto.entidade.JornadaTrabalho;

//@FacesConverter("jornadaConvert")
@FacesConverter(forClass = JornadaTrabalho.class)
public class JornadaTrabalhoConverter implements Converter {
		//JornadaTrabalhoControl serv = new JornadaTrabalhoControl();
	    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
	    	
	        if(value != null && !value.isEmpty()) {
	        	return (JornadaTrabalho) uic.getAttributes().get(value);
	        	
	        }
	        return null;
	    }

	    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
	    	if(object instanceof JornadaTrabalho) {
	    		JornadaTrabalho jornada = (JornadaTrabalho) object;
	    		if(jornada != null && jornada instanceof JornadaTrabalho && jornada.getId() != null) {
	    			uic.getAttributes().put(jornada.getId().toString(), jornada);
	    			return jornada.getId().toString();
	    		}
	    	}
	    	return "";
	    } 
}
