package br.com.senai.fatesg.controleponto.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.hateoas.ResourceSupport;

@Entity
public class AjusteDeRegistro extends ResourceSupport{
	
	@Id
	@GeneratedValue(generator = "registro_ponto_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "registro_ponto_seq", sequenceName = "registro_ponto_seq", allocationSize = 1, initialValue = 1)
	private Long idRegistro;	
	private String data;
	private String nomeFuncionario;
	private int codigoJornadaTrabalho;
	private String primeiraEntrada;
	private String primeiraSaida;
	private String segundaEntrada;
	private String segundaSaida;
	private Long saldo;
	
	public AjusteDeRegistro() {
	}
		
	
	
	public AjusteDeRegistro(Long idRegistro, String data, String nomeFuncionario, int codigoJornadaTrabalho,
			String primeiraEntrada, String primeiraSaida, String segundaEntrada, String segundaSaida, Long saldo) {
		super();
		this.idRegistro = idRegistro;
		this.data = data;
		this.nomeFuncionario = nomeFuncionario;
		this.codigoJornadaTrabalho = codigoJornadaTrabalho;
		this.primeiraEntrada = primeiraEntrada;
		this.primeiraSaida = primeiraSaida;
		this.segundaEntrada = segundaEntrada;
		this.segundaSaida = segundaSaida;
		this.saldo = saldo;
	}



	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	public Long getidRegistro() {
		return idRegistro;
	}
	public void setId(Long idRegistro) {
		this.idRegistro= idRegistro;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getCodigoJornadaTrabalho() {
		return codigoJornadaTrabalho;
	}
	public void setCodigoJornadaTrabalho(int codigoJornadaTrabalho) {
		this.codigoJornadaTrabalho = codigoJornadaTrabalho;
	}
	public String getPrimeiraEntrada() {
		return primeiraEntrada;
	}
	public void setPrimeiraEntrada(String primeiraEntrada) {
		this.primeiraEntrada = primeiraEntrada;
	}
	public String getPrimeiraSaida() {
		return primeiraSaida;
	}
	public void setPrimeiraSaida(String primeiraSaida) {
		this.primeiraSaida = primeiraSaida;
	}
	public String getSegundaEntrada() {
		return segundaEntrada;
	}
	public void setSegundaEntrada(String segundaEntrada) {
		this.segundaEntrada = segundaEntrada;
	}
	public String getSegundaSaida() {
		return segundaSaida;
	}
	public void setSegundaSaida(String segundaSaida) {
		this.segundaSaida = segundaSaida;
	}
	public Long getSaldo() {
		return saldo;
	}
	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}
	
	
}
