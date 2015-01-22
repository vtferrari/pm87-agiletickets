package br.com.caelum.agiletickets.models;

public enum TipoDeEspetaculo {
	
	CINEMA (0.05,0.10),
	SHOW(0.05,0.10),
	TEATRO(0.5,0.20),
	BALLET(0.5,0.20),
	ORQUESTRA(0.5,0.20);
	
	private final double taxaLugar;
	private final double acrescimoPercento;
	
	private TipoDeEspetaculo(double taxaLugar,double acrescimoPercento) {
		this.taxaLugar =  taxaLugar;
		this.acrescimoPercento = acrescimoPercento;
	}
	
	public double getAcrescimoPercento() {
		return acrescimoPercento;
	}
	public double getTaxaLugar() {
		return taxaLugar;
	}
	
	
	
}
