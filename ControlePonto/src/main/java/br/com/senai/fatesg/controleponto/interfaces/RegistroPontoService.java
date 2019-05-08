package br.com.senai.fatesg.controleponto.interfaces;

import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.com.senai.fatesg.controleponto.entidade.AjusteDeRegistro;

public interface RegistroPontoService extends GenericOperations<AjusteDeRegistro>, Persistencia<AjusteDeRegistro>{
	
}
