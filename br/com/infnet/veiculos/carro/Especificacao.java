package br.com.infnet.veiculos.carro;

public class Especificacao extends Veiculo {
				
	private  String montadora;
	private  String modelo;
	private  String tipo;
	private  String cambio;
	
	/*Construtor padrão*/
	public Especificacao() {
		super();
	}
	
	/*
	 * Construtor 2*/
	public Especificacao(String montadora, String modelo, String tipo) {
		super();
		this.montadora = montadora;
		this.modelo = modelo;
		this.tipo = tipo;
	}

	enum Montadora{
		FORD, GM, FIAT, VOLKS, HONDA, FERRAI, KIA, HYUNDAY, YAMAHA, SUZIKI, DAFRA, KAVASAKI, KASINSKI, BMW;
	}
	
	 enum Tipo{
		SEDAN, HACTH, MINIVAN, PERUA, PICAPE, SUV, ESPORTIVO, UTILITARIO_COMERCIAL;
	}

	 enum Cambio{
		 MANUAL,AUTOMATICO;
	 }
	 
	public String getMontadora() {
		return montadora;
	}

	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	
	
	
}
