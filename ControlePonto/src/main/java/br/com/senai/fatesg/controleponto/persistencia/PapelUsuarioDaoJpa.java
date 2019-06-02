package br.com.senai.fatesg.controleponto.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.controleponto.entidade.PapelUsuario;

@Repository("papelUsuarioDao")
public class PapelUsuarioDaoJpa extends PersistenciaJpa<PapelUsuario> implements PapelUsuarioDao{

}
