package br.com.infnet.carro;
//comentarios
import br.com.infnet.veiculos.carro.Especificacao;

public class TipoCarro extends Especificacao {

	private double motorizacao;
	private String cambio;

	
	public double getMotorizacao() {
		return motorizacao;
	}

	public void setMotorizacao(double motorizacao) {
		this.motorizacao = motorizacao;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

}
