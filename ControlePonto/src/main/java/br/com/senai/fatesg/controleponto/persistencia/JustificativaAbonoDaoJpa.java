package br.com.senai.fatesg.controleponto.persistencia;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.util.UtilLog;
import br.com.senai.fatesg.controleponto.entidade.JustificativaAbono;
import br.com.senai.fatesg.controleponto.entidade.Usuario;

@Repository("justificativaAbonoDao")
public class JustificativaAbonoDaoJpa extends PersistenciaJpa<JustificativaAbono> implements JustificativaAbonoDao{

   private static final long serialVersionUID = 1L;
   
   public List<JustificativaAbono> consultarPorNome(String nomePessoa) throws PersistenceException {
       try {
           TypedQuery<JustificativaAbono> query = em.createQuery("select distinct u from Usuario u left join fetch u.pessoa p where upper(p.nomePessoa) like upper(:nomePessoa)", JustificativaAbono.class);
           query.setParameter("nomePessoa", "%" + nomePessoa + "%");
           return query.getResultList();
       } catch (Exception e) {
           UtilLog.getLog().error(e.getMessage(), e);
           throw new PersistenceException("Erro ao consultar o usuÃ¡rio");
       }
   }
}
