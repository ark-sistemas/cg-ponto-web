package br.com.senai.fatesg.controleponto.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class AjusteDeRegistro{
	
	@Id
	@GeneratedValue(generator = "registro_ponto_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "registro_ponto_seq", sequenceName = "registro_ponto_seq", allocationSize = 1, initialValue = 1)
	private Long idRegistro;	
	private String data;
	private String nomeFuncionario;
	private String codigoJornadaTrabalho;
	private String primeiraEntrada;
	private String primeiraSaida;
	private String segundaEntrada;
	private String segundaSaida;
	private Long saldo;
	
	public AjusteDeRegistro() {
	}
	
	public AjusteDeRegistro(Long idRegistro, String data, String nomeFuncionario, String codigoJornadaTrabalho,
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
	public String getCodigoJornadaTrabalho() {
		return codigoJornadaTrabalho;
	}
	public void setCodigoJornadaTrabalho(String codigoJornadaTrabalho) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((idRegistro == null) ? 0 : idRegistro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AjusteDeRegistro other = (AjusteDeRegistro) obj;
		if (idRegistro == null) {
			if (other.idRegistro != null)
				return false;
		} else if (!idRegistro.equals(other.idRegistro))
			return false;
		return true;
	}
	
	
}
