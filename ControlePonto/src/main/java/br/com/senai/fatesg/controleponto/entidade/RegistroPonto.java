package br.com.senai.fatesg.controleponto.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="registro_ponto")
public class RegistroPonto{
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long idRegistro;
	
	private String data;
	
	@Column(name = "id_funcionario")
	private Long idFuncionario;
	
	@Column(name = "idcodigo_jornada_trabalho", length = 50, nullable = false)
	private Long idcodigoJornadaTrabalho;
	
	@Column(name = "primeira_entrada", length = 50, nullable = false)
	private String primeiraEntrada;
	
	@Column(name = "primeira_saida", length = 50, nullable = false)
	private String primeiraSaida;
	
	@Column(name = "segunda_entrada", length = 50, nullable = false)
	private String segundaEntrada;
	
	@Column(name = "segunda_saida", length = 50, nullable = false)
	private String segundaSaida;
	
	private Long saldo;
	
		
	public RegistroPonto() {
	}
	
	public RegistroPonto(Long idRegistro, String data, Long idFuncionario, Long idcodigoJornadaTrabalho,
			String primeiraEntrada, String primeiraSaida, String segundaEntrada, String segundaSaida, Long saldo) {
		super();
		this.idRegistro = idRegistro;
		this.data = data;
		this.idFuncionario = idFuncionario;
		this.idcodigoJornadaTrabalho = idcodigoJornadaTrabalho;
		this.primeiraEntrada = primeiraEntrada;
		this.primeiraSaida = primeiraSaida;
		this.segundaEntrada = segundaEntrada;
		this.segundaSaida = segundaSaida;
		this.saldo = saldo;
	}
	
	public Long getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(Long idRegistro) {
		this.idRegistro = idRegistro;
	}

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Long getIdcodigoJornadaTrabalho() {
		return idcodigoJornadaTrabalho;
	}

	public void setIdcodigoJornadaTrabalho(Long idcodigoJornadaTrabalho) {
		this.idcodigoJornadaTrabalho = idcodigoJornadaTrabalho;
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
		RegistroPonto other = (RegistroPonto) obj;
		if (idRegistro == null) {
			if (other.idRegistro != null)
				return false;
		} else if (!idRegistro.equals(other.idRegistro))
			return false;
		return true;
	}
	
	
}
