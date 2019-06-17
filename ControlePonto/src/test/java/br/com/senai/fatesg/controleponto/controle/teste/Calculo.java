package br.com.senai.fatesg.controleponto.controle.teste;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senai.fatesg.controleponto.entidade.RegistroPonto;
import br.com.senai.fatesg.controleponto.persistencia.AjusteDeRegistroDao;

public class Calculo {
	@Autowired
	private static AjusteDeRegistroDao ajusteDeRegistroDao;
	private static List<RegistroPonto> registros = new ArrayList<RegistroPonto>();
	public static void main(String[] args) {
//		carregar();
		calc();
	}
	public static void carregar() {
		try {
			registros = ajusteDeRegistroDao.listar();
			
		} catch (NullPointerException e) {
			
		}
	}
	public static void calc() {
		String entrada = "08:00";
		String saida = "12:00";
		String entrada2 = "16:00";
		String saida2 = "18:00";
		
//		for (RegistroPonto rp : registros) {
		Double somaPrimeira;
		Double somaSegunda;
		Double soma;
		Double pe = (Double.parseDouble(entrada.substring(0, 2)));
		Double pe2 = Double.parseDouble(entrada.substring(3, 5));
		Double ps = Double.parseDouble(saida.substring(0, 2));
		Double ps2 = Double.parseDouble(saida.substring(3, 5));
		somaPrimeira = ((ps/60)+ps2) - ((pe/60)+pe2);
		Double se = Double.parseDouble(entrada2.substring(0, 2));
		Double se2 = Double.parseDouble(entrada2.substring(3, 5));
		Double ss = Double.parseDouble(saida2.substring(0, 2));
		Double ss2 = Double.parseDouble(saida2.substring(3, 5));
		somaSegunda = ((ss/60)+ss2) - ((se/60)+se2);
		soma = somaPrimeira + somaSegunda;
		System.out.println(soma*60);
//		}
	}
}
