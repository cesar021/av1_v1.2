package br.edu.infnet;

import java.util.HashMap;
import java.util.Map;

public class Veiculo {

	private TipoVeiculo tipoVeiculo;
	private String chassi;
	private Double preco;
	
	private Map<String, String> especificacao;
	
	public Veiculo(TipoVeiculo tipoVeiculo, String chassi, Double preco) {
		
		this.tipoVeiculo = tipoVeiculo;
		this.chassi = chassi;
		this.preco = preco;
		
		this.especificacao = new HashMap<String, String>();
		
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

	public void setEspecificacao(Map<String, String> especificacao) {
		this.especificacao = especificacao;
	}

	public Map<String, String> getEspecificacao() {
		return especificacao;
	}
	
	public Map<String, String> getVeiculo() {
		
		Map<String, String> mapVeiculo = new HashMap<String, String>();
		
		mapVeiculo.put("TIPOVEICULO", this.tipoVeiculo.name());
		mapVeiculo.put("CHASSI", this.chassi);
		mapVeiculo.put("PRECO", this.preco.toString());
		
		mapVeiculo.putAll(this.especificacao);
		
		return mapVeiculo;
	}
	
	
}
