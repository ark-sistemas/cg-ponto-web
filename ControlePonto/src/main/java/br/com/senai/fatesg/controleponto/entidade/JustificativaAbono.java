package br.com.senai.fatesg.controleponto.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="justificativa_ponto")
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
	@Lob
	@Column(name = "anexo_documento")
	private byte[] anexoDocumento;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name = "horas_diaria_inicio")
	private String horasDiariaInicio;
	
	@Column(name = "horas_diaria_termino")
	private String horasDiariaTermino;
	
	@Column(name = "data_inicio")
	private String dataInicio;
	
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
	public Date getData() {return data;	}
	public void setData(Date data) {this.data = data;}
	//public List<Funcionario> getFuncionarios() {return funcionarios;}
	//public void setFuncionarios(List<Funcionario> funcionarios) {
	//	this.funcionarios = funcionarios;
	//}
	//GETTERS
	public String getTitulo() {return titulo;}							//TITULO
	public String getDescricao() {return descricao;}					//DESCRICAO
	//public String getanexoDocumento() {return anexoDocumento;}
	public byte[] getAnexoDocumento(){return anexoDocumento;}			//ANEXO DOCUMENTOS
	public String getHorasDiariaInicio() {return horasDiariaInicio;}	//HORAS DIARIAS INICIO
	public String getHorasDiariaTermino() {return horasDiariaTermino;}	//HORAS DIARIAS TERMINO
	public String getDataInicio() {return dataInicio;}					//DATA INICIO
	public String getDataTermino() {return dataTermino;}				//DATA TERMINO
	public String getStatus() {return status;}							//STATUS
	
	//SETTERS
	public void setTitulo(String titulo) {this.titulo = titulo;}													//TITULO
	public void setDescricao(String descricao) {this.descricao = descricao;}										//DESCRICAO
	//public void setAnexoDocumento(String anexoDocumento) {this.anexoDocumento = anexoDocumento;}
	public void setAnexoDocumento(byte[] anexoDocumento) {this.anexoDocumento = anexoDocumento;}		   			//ANEXO DOCUMENTOS
	public void setHorasDiariaInicio(String horasDiariaInicio) {this.horasDiariaInicio = horasDiariaInicio;}		//HORAS DIARIAS INICIO
	public void setHorasDiariaTermino(String horasDiariaTermino) {this.horasDiariaTermino = horasDiariaTermino;}	//HORAS DIARIAS TERMINO
	public void setDataInicio(String dataInicio) {this.dataInicio = dataInicio;}									//DATA INICIO
	public void setDataTermino(String dataTermino) {this.dataTermino = dataTermino;}								//DATA TERMINO
	public void setStatus(String status) {this.status = status;}													//STATUS
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	
}
