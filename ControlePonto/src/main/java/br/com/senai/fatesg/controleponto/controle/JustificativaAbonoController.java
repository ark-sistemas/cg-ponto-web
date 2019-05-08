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

import br.com.senai.fatesg.controleponto.entidade.JustificativaAbono;
import br.com.senai.fatesg.controleponto.interfaces.JustificativaAbonoService;

@RestController("/abono")
public class JustificativaAbonoController implements GenericOperationsController<JustificativaAbono>{

	@Autowired
	public JustificativaAbonoService abonoService;
	
	
	@Override
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
			 				MediaType.APPLICATION_XML_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE,
							MediaType.APPLICATION_XML_VALUE,
							MediaTypes.HAL_JSON_VALUE})
@ResponseStatus(HttpStatus.CREATED)
	public Resource<JustificativaAbono> post(JustificativaAbono entity) {
		
		abonoService.incluir(entity);
		
		Link link = linkTo(JustificativaAbonoController.class).slash(entity.getId()).withSelfRel();
		Resource<JustificativaAbono> result = new Resource<JustificativaAbono>(entity,link);

		return result;
	}

	@Override
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
							MediaType.APPLICATION_XML_VALUE})
@ResponseStatus(HttpStatus.NO_CONTENT)
	public void put(JustificativaAbono entity) {
		
		abonoService.alterar(entity);
		Link link = linkTo(JustificativaAbono.class).slash(entity.getId()).withSelfRel();
		
	}

	@Override
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
							MediaType.APPLICATION_XML_VALUE})
@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(JustificativaAbono entity) {
		abonoService.excluirPorId(entity.getId());
	}

	@Override
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
			 				MediaType.APPLICATION_XML_VALUE,
			 				MediaTypes.HAL_JSON_VALUE})
@ResponseStatus(HttpStatus.OK)
	public Resources<JustificativaAbono> get() {
		List<JustificativaAbono> allAbono = abonoService.listar();
		List<JustificativaAbono> all = new ArrayList<JustificativaAbono>();
		for(JustificativaAbono abono : allAbono) {
			String abonoId = String.valueOf(abono.getId());
			Link selfLink = linkTo(JustificativaAbono.class).slash(abonoId).withSelfRel();
			abono.add(selfLink);
			all.add(abono);
		}
		
		Link link = linkTo(JustificativaAbono.class).withSelfRel();
		Resources<JustificativaAbono> result = new Resources<JustificativaAbono>(all,link);
		return result;
	}

	@Override
	@GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
							MediaType.APPLICATION_XML_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE,
							MediaType.APPLICATION_XML_VALUE,
							MediaTypes.HAL_JSON_VALUE})
@ResponseStatus(HttpStatus.OK)
	public Resource<JustificativaAbono> get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PatchMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
							  MediaType.APPLICATION_XML_VALUE})
@ResponseStatus(HttpStatus.NO_CONTENT)
	public void patch(JustificativaAbono entity) {
		// TODO Auto-generated method stub
		
	}

	

}
