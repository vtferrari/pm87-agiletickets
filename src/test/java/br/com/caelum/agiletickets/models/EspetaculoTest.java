package br.com.caelum.agiletickets.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import junit.framework.Assert;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Test;

public class EspetaculoTest {

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(5));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(6));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(15));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(5, 3));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(10, 3));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(5, 3));
	}

	private Sessao sessaoComIngressosSobrando(int quantidade) {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(quantidade * 2);
		sessao.setIngressosReservados(quantidade);

		return sessao;
	}
	
	@Test
	public void criaUmaUnicaSessaoParaEspetaculo() {
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = LocalDate.now();
		LocalDate fim = LocalDate.now();
		LocalTime horario = LocalTime.now();
		Periodicidade periodicidade = Periodicidade.DIARIA;
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, periodicidade);
		Assert.assertEquals(1, sessoes.size());
	}

	@Test
	public void criaEspetaculoDiariamente7Dias(){
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = LocalDate.now();
		LocalDate fim = LocalDate.now().plusWeeks(1);
		LocalTime horario = LocalTime.now();
		Periodicidade periodicidade = Periodicidade.DIARIA;
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, periodicidade);
		Assert.assertEquals(8, sessoes.size());
	}

	@Test
	public void criaEspetaculoSemanal1Semana(){
		Espetaculo espetaculo = new Espetaculo();
		LocalDate inicio = LocalDate.now();
		LocalDate fim = LocalDate.now().plusWeeks(1);
		LocalTime horario = LocalTime.now();
		Periodicidade periodicidade = Periodicidade.SEMANAL;
		
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, periodicidade);
		Assert.assertEquals(2, sessoes.size());
	}
}
