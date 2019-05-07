package br.com.senai.fatesg.controleponto.controle;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.fatesg.controleponto.entidade.AjusteDeRegistro;
import br.com.senai.fatesg.controleponto.interfaces.RegistroPontoService;

@RestController("/registro")
public class RegistroPontoController implements GenericOperationsController<AjusteDeRegistro>{

	@Autowired
	public RegistroPontoService registroService;
	
	
	@Override
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
			 				MediaType.APPLICATION_XML_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE,
							MediaType.APPLICATION_XML_VALUE,
							MediaTypes.HAL_JSON_VALUE})
@ResponseStatus(HttpStatus.CREATED)
	public Resource<AjusteDeRegistro> post(AjusteDeRegistro entity) {
		
		registroService.post(entity);
		
		Link link = linkTo(RegistroPontoController.class).slash(entity.getId()).withSelfRel();
		Resource<AjusteDeRegistro> result = new Resource<AjusteDeRegistro>(entity,link);

		return result;
	}

	@Override
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
							MediaType.APPLICATION_XML_VALUE})
@ResponseStatus(HttpStatus.NO_CONTENT)
	public void put(AjusteDeRegistro entity) {
		
		registroService.post(entity);
		Link link = linkTo(AjusteDeRegistro.class).slash(entity.getId()).withSelfRel();
		
	}

	@Override
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
							MediaType.APPLICATION_XML_VALUE})
@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(AjusteDeRegistro entity) {
		registroService.delete(entity);
	}

	@Override
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
			 				MediaType.APPLICATION_XML_VALUE,
			 				MediaTypes.HAL_JSON_VALUE})
@ResponseStatus(HttpStatus.OK)
	public Resources<AjusteDeRegistro> get() {
		List<AjusteDeRegistro> allRegistros = registroService.get();
		List<AjusteDeRegistro> all = new ArrayList<AjusteDeRegistro>();
		for(AjusteDeRegistro registro : allRegistros) {
			String registroId = String.valueOf(registro.getidRegistro());
			Link selfLink = linkTo(AjusteDeRegistro.class).slash(registroId).withSelfRel();
			registro.add(selfLink);
			all.add(registro);
		}
		
		Link link = linkTo(AjusteDeRegistro.class).withSelfRel();
		Resources<AjusteDeRegistro> result = new Resources<AjusteDeRegistro>(all,link);
		return result;
	}

	@Override
	@GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
							MediaType.APPLICATION_XML_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE,
							MediaType.APPLICATION_XML_VALUE,
							MediaTypes.HAL_JSON_VALUE})
@ResponseStatus(HttpStatus.OK)
	public Resource<AjusteDeRegistro> get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PatchMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
							  MediaType.APPLICATION_XML_VALUE})
@ResponseStatus(HttpStatus.NO_CONTENT)
	public void patch(AjusteDeRegistro entity) {
		// TODO Auto-generated method stub
		
	}

	

}
