package br.com.senai.fatesg.controleponto.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Empresa {
	
	@Id
	@GeneratedValue(generator="id_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="id_seq", sequenceName="id_seq", allocationSize=1, initialValue=1)
	private long id;
	
	@Column(name = "cnpj", length = 14, nullable = false)
	private long cnpj;
	
	@Column(name = "razaosocial", length = 50, nullable = false)
	private String razaoSocial;
	
	@Column(name = "nomeFantasia", length = 50, nullable = false)
	private String nomeFantasia;
	
	@Column(name = "logradouro", length = 50, nullable = false)
	private String logradouro;
	
	@Column(name = "numero", length = 8, nullable = false)
	private String numero;
	
	@Column(name = "complemento", length = 50, nullable = false)
	private String complemento;
	
	@Column(name = "bairro", length = 50, nullable = false)
	private String bairro;
	
	@Column(name = "cidade", length = 30, nullable = false)
	private String cidade;
	
	@Column(name = "estado", length = 2, nullable = false)
	private String estado;
	
	@Column(name = "cep", length = 10, nullable = false)
	private String cep;
	
	@Column(name = "inscricaoEstadual", length = 12, nullable = false)
	private String inscricaoEstadual;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "telefone", length = 12, nullable = false)
	private String telefone;
	
	@Column(name = "site", length = 50, nullable = false)
	private String site;
	
	@Column(name = "redeSocial", length = 50, nullable = false)
	private String redeSocial;
	
	@Column(name = "porcetagemHorasExtras", length = 5, nullable = false)
	private Double porcentagemHorasExtras;
	
	
	
	public Empresa() {
		super();
	}

	public Empresa(long id, long cnpj, String razaoSocial, String nomeFantasia, String logradouro, String numero,
			String complemento, String bairro, String cidade, String estado, String cep, String inscricaoEstadual,
			String email, String fone, String site, String redeSocial, Double porcentagemHorasExtras) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.inscricaoEstadual = inscricaoEstadual;
		this.email = email;
		this.telefone = fone;
		this.site = site;
		this.redeSocial = redeSocial;
		this.porcentagemHorasExtras = porcentagemHorasExtras;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getRedeSocial() {
		return redeSocial;
	}
	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}
	public Double getPorcentagemHorasExtras() {
		return porcentagemHorasExtras;
	}
	public void setPorcentagemHorasExtras(Double porcentagemHorasExtras) {
		this.porcentagemHorasExtras = porcentagemHorasExtras;
	}

	
	
}
