package br.com.senai.fatesg.controleponto.entidade;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;



//@Entity
//@Table(name = "jornada")
public class JornadaTrabalho implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "jornadaTrabalho_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "jornadaTrabalho_seq", sequenceName = "jornadaTrabalho_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	@Column(name = "descricao", length = 50, nullable = false)
	private String descricao;
	
	@Column(name = "diasDaSemana", length = 50, nullable = false)
	private String[] diasDaSemana;

	@Column(name = "inicioHorasDiaria", length = 8, nullable = false)
	private String inicioHorasDiaria;

	@Column(name = "terminoHorasDiaria", length = 8, nullable = false)
	private String terminoHorasDiaria;
	
	@Column(name = "inicioHorasIntervalo", length = 8, nullable = false)
	private String inicioHorasIntervalo;

	@Column(name = "terminoHorasIntervalo", length = 8, nullable = false)
	private String terminoHorasIntervalo;

	@Column(name = "horasSemanais", length = 5, nullable = false)
	private double horasSemanais;
	
	@Column(name = "horasMensais", length = 5, nullable = false)
	private double horasMensais;
	
	private String mostraDias = "";
	
	
	
	@OneToMany(mappedBy = "jornada", orphanRemoval = false)
	@Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE, 
			org.hibernate.annotations.CascadeType.PERSIST, 
			org.hibernate.annotations.CascadeType.MERGE, 
			org.hibernate.annotations.CascadeType.REFRESH})
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
	
	public JornadaTrabalho(Integer id, String descricao, String[] diasDaSemana, String inicioHorasDiaria,
			String terminoHorasDiaria, String inicioHorasIntervalo, String terminoHorasIntervalo, double horasSemanais,
			double horasMensais, String mostraDias) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.diasDaSemana = diasDaSemana;
		this.inicioHorasDiaria = inicioHorasDiaria;
		this.terminoHorasDiaria = terminoHorasDiaria;
		this.inicioHorasIntervalo = inicioHorasIntervalo;
		this.terminoHorasIntervalo = terminoHorasIntervalo;
		this.horasSemanais = horasSemanais;
		this.horasMensais = horasMensais;
		this.mostraDias = mostraDias;
	}
	public JornadaTrabalho() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String[] getDiasDaSemana() {
		return diasDaSemana;
	}
	
	public void mostraDias()
	{
		for (int i = 0; i < diasDaSemana.length; i++) {
			mostraDias+=diasDaSemana[i] + ", ";
		}
		
	}
	

	public String getMostraDias() {
		return mostraDias;
	}

	public void setMostraDias(String mostraDias) {
		this.mostraDias = mostraDias;
	}

	public void setDiasDaSemana(String[] diasDaSemana) {
		this.diasDaSemana = diasDaSemana;

	}
	
	public double getHorasSemanais() {
		return horasSemanais;
	}

	public void setHorasSemanais(double horasSemanais) {
		this.horasSemanais = horasSemanais;
	}

	public double getHorasMensais() {
		return horasMensais;
	}

	public void setHorasMensais(double horasMensais) {
		this.horasMensais = horasMensais;
	}
	
	
	
	public String getInicioHorasDiaria() {
		return inicioHorasDiaria;
	}
	public void setInicioHorasDiaria(String inicioHorasDiaria) {
		this.inicioHorasDiaria = inicioHorasDiaria;
	}
	public String getTerminoHorasDiaria() {
		return terminoHorasDiaria;
	}
	public void setTerminoHorasDiaria(String terminoHorasDiaria) {
		this.terminoHorasDiaria = terminoHorasDiaria;
	}
	public String getInicioHorasIntervalo() {
		return inicioHorasIntervalo;
	}
	public void setInicioHorasIntervalo(String inicioHorasIntervalo) {
		this.inicioHorasIntervalo = inicioHorasIntervalo;
	}
	public String getTerminoHorasIntervalo() {
		return terminoHorasIntervalo;
	}
	public void setTerminoHorasIntervalo(String terminoHorasIntervalo) {
		this.terminoHorasIntervalo = terminoHorasIntervalo;
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
		JornadaTrabalho other = (JornadaTrabalho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return getDescricao();
	}
	
	
	
	
}
