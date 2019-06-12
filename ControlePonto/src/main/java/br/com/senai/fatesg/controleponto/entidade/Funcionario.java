package br.com.senai.fatesg.controleponto.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Funcionario")
public class Funcionario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "funcionario_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "funcionario_seq", sequenceName = "funcionario_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "logradouro", length = 30, nullable = false)
	private String logradouro;
	
	@Column(name = "numero", length = 7, nullable = false)
	private String numero;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataNascimento", length = 8, nullable = false)
	private Date dataNascimento;
	
	@Column(name = "estadoCivil", length = 30, nullable = false)
	private String estadoCivil;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "complemento", length = 50, nullable = false)
	private String complemento;

	@Column(name = "bairro", length = 30, nullable = false)
	private String bairro;

	@Column(name = "cidade", length = 40, nullable = false)
	private String cidade;

	@Column(name = "estado", length = 30, nullable = false)
	private String estado;

	@Column(name = "cep", length = 20, nullable = false)
	private String cep;

	@Column(name = "telefone", length = 20, nullable = false)
	private String telefone;

	@Column(name = "celular", length = 20, nullable = false)
	private String celular;

	@Column(name = "cpf", length = 15, nullable = false)
	private String cpf;

	@Column(name = "bancoHoras", length = 20, nullable = false)
	private String bancoHoras;

	@Column(name="Status", length=1, nullable=false)
	private char status;

	//@Basic
	//@ForeignKey(name = "jornada_fk")
	@ManyToOne
	@JoinColumn(name = "jornada", nullable = false)
	private JornadaTrabalho jornada = new JornadaTrabalho();
	
	
	@ManyToMany(cascade = { 
	        CascadeType.PERSIST, 
	        CascadeType.MERGE
	    },
		//mappedBy = "funcionarios",
	        targetEntity = JustificativaAbono.class
	)
	    @JoinTable(name = "RegistroJustificativa",
	        joinColumns = @JoinColumn(name = "idFuncionario"),
	        inverseJoinColumns = @JoinColumn(name = "idJustificativaAbono")
	    )
	private List<JustificativaAbono> justificativasAbonos;
	
	@ManyToOne
	private Usuario login = new Usuario();
	
	public String getMostrarPapel() {
		String aux = "";
		for (int i = 0; i < login.getPapeis().size(); i++) {
			PapelUsuario skin = login.getPapeis().iterator().next();
			if(!skin.equals(null)) {
				
				aux =  skin.getPapel().name();
			}
		}
		return aux;
	}
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(Integer id, String nome, String logradouro, String numero, Date dataNascimento,
			String estadoCivil, String email, String complemento, String bairro, String cidade, String estado,
			String cep, String telefone, String celular, String cpf, String bancoHoras, char status,
			JornadaTrabalho jornada, List<JustificativaAbono> justificativasAbonos, Usuario login) {
		super();
		this.id = id;
		this.nome = nome;
		this.logradouro = logradouro;
		this.numero = numero;
		this.dataNascimento = dataNascimento;
		this.estadoCivil = estadoCivil;
		this.email = email;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.telefone = telefone;
		this.celular = celular;
		this.cpf = cpf;
		this.bancoHoras = bancoHoras;
		this.status = status;
		this.jornada = jornada;
		this.justificativasAbonos = justificativasAbonos;
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getLogin() {
		return login;
	}

	public void setLogin(Usuario login) {
		this.login = login;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public JornadaTrabalho getJornada() {
		return jornada;
	}

	public void setJornada(JornadaTrabalho jornada) {
		this.jornada = jornada;
	}

	public List<JustificativaAbono> getJustificativasAbonos() {
		return justificativasAbonos;
	}

	public void setJustificativasAbonos(List<JustificativaAbono> justificativasAbonos) {
		this.justificativasAbonos = justificativasAbonos;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBancoHoras() {
		return bancoHoras;
	}

	public void setBancoHoras(String bancoHoras) {
		this.bancoHoras = bancoHoras;
	}

	public boolean getStatus() {
		if(this.status == '1') {
			return true;
		}else {
			return false;
		}
	}
	public void setStatus(boolean status) {
		if(status == true) {
			this.status = '1';
		}else {
			this.status = '0';
		}
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getNome();
	}

	

	
	
}
