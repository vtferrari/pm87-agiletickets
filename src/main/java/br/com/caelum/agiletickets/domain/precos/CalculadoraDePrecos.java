package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco;
		
		if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.CINEMA) || 
				sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.SHOW)) {
			
			preco = porcento(sessao,0.05,0.10);
		
		} else if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.BALLET)) {
			
			preco = porcento(sessao,0.50,0.20);
			preco = acrescenta10Porcento(sessao, preco);
		
		} else if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.ORQUESTRA)) {
			
			preco = porcento(sessao,0.50,0.20);
			preco = acrescenta10Porcento(sessao, preco);
		
		}  else {
			
			preco = sessao.getPreco();
		
		} 

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

	private static BigDecimal porcento(Sessao sessao, double porcentagemDeLugaresParaTaxa, double acrescimo) {
		if(lugaresOcupados(sessao) <= porcentagemDeLugaresParaTaxa) { 
			return sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(acrescimo)));
		} 
		return sessao.getPreco();
	}

	private static double lugaresOcupados(Sessao sessao) {
		int reservas = sessao.getTotalIngressos() - sessao.getIngressosReservados();
		return reservas / sessao.getTotalIngressos().doubleValue();
	}

	private static BigDecimal acrescenta10Porcento(Sessao sessao, BigDecimal preco) {
		if(sessao.getDuracaoEmMinutos() > 60){
			preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		}
		return preco;
	}

}