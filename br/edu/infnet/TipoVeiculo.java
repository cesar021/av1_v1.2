package br.edu.infnet;

public enum TipoVeiculo {
	CARRO(0), MOTO(1);
	
	private final int id;
	
	TipoVeiculo(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
}
