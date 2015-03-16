package br.edu.infnet;

public class Especificacao {

	private Montadora montadora;
	private String modelo;
	private Tipo tipo;
	private Cor cor;
	
	// Carro
	private Double motorizacao;
	private Cambio cambio;

	// Moto
	private Double cilindrada;
	private int capacidadeTank;
	
	public Especificacao() {
		
	}
	
	public Especificacao(Montadora montadora, String modelo, Tipo tipo, Cor cor, Double motorizacao, Cambio cambio) {

		// Especificacao Carro
		
		this.montadora = montadora;
		this.modelo = modelo;
		this.tipo = tipo;
		this.cor = cor;
		this.motorizacao = motorizacao;
		this.cambio = cambio;
		
		this.cilindrada = 0.00;
		this.capacidadeTank = 0;		
	}

	public Especificacao(Montadora montadora, String modelo, Tipo tipo, Cor cor, Double cilindrada, int capacidadeTank) {

		// Especificacao Moto
		
		this.montadora = montadora;
		this.modelo = modelo;
		this.tipo = tipo;
		this.cor = cor;
		
		this.cilindrada = cilindrada;
		this.capacidadeTank = capacidadeTank;
		
		this.motorizacao = 0.00;
		this.cambio = null;
		
				
	}

	
	public Montadora getMontadora() {
		return montadora;
	}
	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Cor getCor() {
		return cor;
	}
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	public Double getMotorizacao() {
		return motorizacao;
	}
	public void setMotorizacao(Double motorizacao) {
		this.motorizacao = motorizacao;
	}
	public Cambio getCambio() {
		return cambio;
	}
	public void setCambio(Cambio cambio) {
		this.cambio = cambio;
	}
	public Double getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(Double cilindrada) {
		this.cilindrada = cilindrada;
	}
	public int getCapacidadeTank() {
		return capacidadeTank;
	}
	public void setCapacidadeTank(int capacidadeTank) {
		this.capacidadeTank = capacidadeTank;
	}
	
	
}
