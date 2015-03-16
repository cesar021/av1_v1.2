package br.edu.infnet;

public class Loja {
	
	private String endereco;
	private String nome;
	
	private Veiculo[] estoqueVeiculos;

	public Loja(String nome, String endereco) {
		
		this.nome = nome;
		this.endereco = endereco;
		
		estoqueVeiculos = new Veiculo[0];
		
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Veiculo[] getEstoqueVeiculos() {
		return estoqueVeiculos;
	}

	public void setEstoqueVeiculos(Veiculo[] estoqueVeiculos) {
		this.estoqueVeiculos = estoqueVeiculos;
	}
	
	public void adicionarCarro(Veiculo veiculo) {
		
		if ( veiculo == null ) 
		{
			System.out.println("Veículo não informado !");
		}
		else
		{
			Veiculo[] auxVeiculo = new Veiculo[this.estoqueVeiculos.length + 1];
			
			for (int p = 0; p <= this.estoqueVeiculos.length-1; p++) {
				
				auxVeiculo[p] = this.estoqueVeiculos[p];
				
			}

			
			
			auxVeiculo[this.estoqueVeiculos.length] = veiculo;
			
			this.estoqueVeiculos = auxVeiculo;
			
			for (int p = 0; p <= this.estoqueVeiculos.length-1; p++) {
				
				System.out.println(this.estoqueVeiculos[p].getChassi());
				
			}
		}
		
	}
	
}
