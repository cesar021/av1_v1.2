package br.edu.infnet;

public class Veiculo {

	private TipoVeiculo tipoVeiculo;
	private String chassi;
	private Double preco;
	
	private Especificacao especificacao;

	public Veiculo(TipoVeiculo tipoVeiculo, String chassi, Double preco) {
		
		this.tipoVeiculo = tipoVeiculo;
		this.chassi = chassi;
		this.preco = preco;
		
		this.especificacao = new Especificacao();
		
	}
	
	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Especificacao getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(Especificacao especificacao) {
		this.especificacao = especificacao;
	}
	
	
	
	
}
