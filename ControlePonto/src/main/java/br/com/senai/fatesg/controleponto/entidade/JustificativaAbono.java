package br.com.senai.fatesg.controleponto.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;


@Entity
public class JustificativaAbono implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="justificativaAbono_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="justificativaAbono_seq", sequenceName="justificativaAbono_seq", allocationSize=1, initialValue=1)
	@Column(name="id")
	private Integer idJustificativa;
	
	private String titulo;
	private String descricao;
	
	//@Type(type = "org.hibernate.type.PrimitiveByteArrayBlobType")
//	@Basic(fetch=FetchType.LAZY, optional=true)
	@Lob
	@Type(type = "org.hibernate.type.ImageType")
	private byte[] anexoDocumento;
	
	@Temporal(TemporalType.DATE)
	private Date data;
		
	@Column(name = "data_termino")
	private String dataTermino;
	
	private String status;
	
	
	
	/*@ManyToMany(fetch = FetchType.LAZY, mappedBy = "justificativasAbonos")
	private List<Funcionario> funcionarios;
	*/
	@ManyToOne
	private Usuario usuarioLogado = new Usuario();
	
	public Integer getIdJustificativa() {
		return idJustificativa;
	}
	public void setIdJustificativa(Integer idJustificativa) {
		this.idJustificativa = idJustificativa;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public byte[] getAnexoDocumento() {
		return anexoDocumento;
	}
	public void setAnexoDocumento(byte[] anexoDocumento) {
		this.anexoDocumento = anexoDocumento;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//STATUS
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	
}
