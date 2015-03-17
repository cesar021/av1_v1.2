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
	
	public void adicionarVeiculo(Veiculo veiculo) {
		
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
		}
		
	}
	
	public void listarEstoquedeVeiculos(TipoVeiculo tipoVeiculo) {
		
		int contatodos = 0;
		
		int[] conta = new int[TipoVeiculo.values().length];
		
		// Inicializando o contador de cada tipo de veículo
		for (TipoVeiculo tipo : TipoVeiculo.values()) {
			conta[tipo.getID()] = 0;
		}
		
		System.out.println("*** INÍCIO DA LISTAGEM");
		System.out.println("");
		System.out.println("Listando " + (tipoVeiculo == null ? "veículo" : tipoVeiculo.name()) + "s do estoque\n");
		
		System.out.println("TIPO\tCHASSI\tMONTADORA\tMODELO");
		
		// Listando e totalizando a quantidade de veiculo por tipo
		for(int p = 0; p <= this.estoqueVeiculos.length-1; p++) {
			
			conta[this.estoqueVeiculos[p].getTipoVeiculo().getID()] += 1;
			
			if ((tipoVeiculo == null) || (tipoVeiculo == this.estoqueVeiculos[p].getTipoVeiculo())) {
				System.out.println(this.estoqueVeiculos[p].getTipoVeiculo().name() + "\t" + this.estoqueVeiculos[p].getChassi() + "\t" + this.estoqueVeiculos[p].getEspecificacao().get("MONTADORA")+ "\t\t" + this.estoqueVeiculos[p].getEspecificacao().get("MODELO")); 
			}
			
		}
		
		System.out.println("");
		// Listando os totais de veiculos por tipo
		for (TipoVeiculo tipo : TipoVeiculo.values()) {
			if ((tipoVeiculo == null) || (tipo == tipoVeiculo)) {
				System.out.println("Quantidade de "+tipo.name()+": "+conta[tipo.getID()]);
				
				contatodos += conta[tipo.getID()];
			}
		}
		
		if ( tipoVeiculo == null ) {
			System.out.println("Quantidade de veículos: "+contatodos);
		}
		
		System.out.println("");
		System.out.println("*** FIM DA LISTAGEM");
		
	}
}
