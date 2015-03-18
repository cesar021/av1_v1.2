package br.edu.infnet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Loja {
	
	private String endereco;
	private String nome;
	
	private Veiculo[] estoqueVeiculos;

	public Loja(String arquivo) {
		
		this("","");		
		
		recuperarEstoque(arquivo);
	
	}

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
			this.estoqueVeiculos = adicionarVeiculoVetor(this.estoqueVeiculos, veiculo);
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
	
	public Veiculo[] pesquisarVeiculo(String pesquisa) {
		
		Veiculo[] retVeiculos = new Veiculo[0];
		
		Map<String, String> mapPesquisa = new HashMap<String, String>();
		
		try {
			for (String spesquisa : pesquisa.split(";")) {
				
				String[] apesquisa = spesquisa.split("="); 
				
				mapPesquisa.put(apesquisa[0], apesquisa[1]);			
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
			
			System.out.println("Parametro de pesquisa inválido !\n\nSyntax: Atributo=VALOR;Atributo=VALOR;...\n\nMONTADORA=BMW;");
		}
		
		for ( Veiculo veiculo : this.estoqueVeiculos ) {
			
			boolean igual = true;
			
			for ( String key : mapPesquisa.keySet() ) {
			
				if (veiculo.getVeiculo().containsKey(key)) {
					
					if (!veiculo.getVeiculo().get(key).equals(mapPesquisa.get(key))) {
						igual = false;
						break;
					}
					
				}
				else
				{
					igual = false;
					break;
				}
			}
			
			if (igual) {
				retVeiculos = adicionarVeiculoVetor(retVeiculos, veiculo);
			}
			
		}
		
		return retVeiculos;		
	}
	
	private Veiculo[] adicionarVeiculoVetor(Veiculo[] vetorVeiculo, Veiculo veiculo) {
		
		Veiculo[] auxVeiculo = new Veiculo[vetorVeiculo.length + 1];
		
		for (int p = 0; p <= vetorVeiculo.length-1; p++) {
			
			auxVeiculo[p] = vetorVeiculo[p];
			
		}
		
		auxVeiculo[vetorVeiculo.length] = veiculo;
		
		return auxVeiculo;
		
	}

	public void salvarEstoque(String arquivo) {
		
		try {
			FileWriter writer = new FileWriter(new File(arquivo));
			
			PrintWriter saida = new PrintWriter(writer);
			
			saida.println("GADS2014N");
			saida.println("loja.estoque.backup");
			saida.println(this.getNome() + ";" + this.getEndereco()+";");
			
			for(Veiculo veiculo : this.estoqueVeiculos) {
				
				String sveiculo = veiculo.getChassi()+";"+veiculo.getTipoVeiculo().name()+";"+veiculo.getPreco()+";"; 
				
				for (String keyVeiculo : veiculo.getEspecificacao().keySet()) {
					
					sveiculo += keyVeiculo + "=" + veiculo.getEspecificacao().get(keyVeiculo) + ";"; 
					
				}
				
				saida.println(sveiculo);
				
			}
			
			saida.close();
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private void recuperarEstoque(String arquivo) {

		try {
			FileReader reader = new FileReader(arquivo);
			
			BufferedReader leitor = new BufferedReader(reader);
			
			String linha = null;
			
			try {
				
				linha = leitor.readLine();
				
				if (!linha.equals("GADS2014N")) {
					System.out.println("Arquivo inválido !");
					try {
						leitor.close();
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
				}
				
				linha = leitor.readLine();
				if (!linha.equals("loja.estoque.backup")) {
					System.out.println("Arquivo inválido !");
					try {
						leitor.close();
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
				}
				
				linha = leitor.readLine();
				
				if (!linha.isEmpty()) {
					
					String[] splLinha = linha.split(";");
					
					this.setNome(splLinha[0]);
					this.setEndereco(splLinha[1]);
					
					
					
				}
				else {
					System.out.println("Arquivo inválido !");
					try {
						leitor.close();
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return;
				}
				
				while ((linha = leitor.readLine()) != null) {

					String[] splLinha = linha.split(";");
				
					Veiculo veiculo = new Veiculo(TipoVeiculo.valueOf(splLinha[1]), splLinha[0], Double.parseDouble(splLinha[2]));
					
					Map<String, String> mapEspecificacao = new HashMap<String, String>();
					
					for(int p = 3; p <= splLinha.length-1;p++) {
						
						String[] splEspecificacao = splLinha[p].split("=");
						
						mapEspecificacao.put(splEspecificacao[0], splEspecificacao[1]);						
					}
					
					veiculo.setEspecificacao(mapEspecificacao);
					
					adicionarVeiculo(veiculo);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			try {
				leitor.close();
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
