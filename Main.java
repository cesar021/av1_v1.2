	import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.Loja;
import br.edu.infnet.Tipo;
import br.edu.infnet.TipoVeiculo;
import br.edu.infnet.Veiculo;
import br.edu.infnet.enums.Cambio;
import br.edu.infnet.enums.Cor;

public class Main {

	public static void main(String[] args) {

		System.out.println("******************************************************");
		System.out.println("* Projeto de uma loja de veículos de uma grande rede *");
		System.out.println("******************************************************");

		System.out.println("");
		
		Loja loja = new Loja("GADS2014N", "Rua São José, 90 - Centro, Rio de Janeiro - RJ, 20010-020");
		
		System.out.println("Loja    : " + loja.getNome());
		System.out.println("Endereço: " + loja.getEndereco());
		
		System.out.println("Quantidade de veículo no estoque: " + loja.getEstoqueVeiculos().length);
		
		Veiculo veiculo = new Veiculo(TipoVeiculo.CARRO, "000001", 70000.00);
		
		Map<String, String> especificacao = new HashMap<String, String>();
		
		especificacao.put("MONTADORA", "BMW");
		especificacao.put("MODELO", "X1");
		especificacao.put("TIPO", Tipo.SUV.name());
		especificacao.put("COR", Cor.PRETO.name());
		especificacao.put("MOTORIZACAO", "2.0");
		especificacao.put("CAMBIO", Cambio.AUTOMATICO.name());
		
		veiculo.setEspecificacao(especificacao);
		
		loja.adicionarVeiculo(veiculo);
		
		System.out.println("Quantidade de veículo no estoque: " + loja.getEstoqueVeiculos().length);
		
		veiculo = new Veiculo(TipoVeiculo.MOTO, "000002", 27000.00);
		
		especificacao = new HashMap<String, String>();
		
		especificacao.put("MONTADORA", "YAMAHA");
		especificacao.put("MODELO", "XJ6");
		especificacao.put("TIPO", Tipo.ESPORTIVO.name());
		especificacao.put("COR", Cor.PRETO.name());
		especificacao.put("CILINDRADA", "600");
		especificacao.put("CAPACIDADETANK", "17.3");
		
		veiculo.setEspecificacao(especificacao);
		
		loja.adicionarVeiculo(veiculo);
		
		System.out.println("");
		
		// Listando todos os veículos do estoque
		loja.listarEstoquedeVeiculos(null);
		
		// Listando apenas os carros do estoque
		loja.listarEstoquedeVeiculos(TipoVeiculo.CARRO);
		
		// Listando apenas as motos do estoque
		loja.listarEstoquedeVeiculos(TipoVeiculo.MOTO);
		
		// Pesquisando veiculos com 1 atributo
		System.out.println("*****************************************");
		System.out.println("Pesquisando veiculos com MONTADORA YAMAHA");
		System.out.println("*****************************************\n");
		System.out.println("TIPO\tCHASSI");
		for (Veiculo pesqVeiculo : loja.pesquisarVeiculo("MONTADORA=YAMAHA;")) {
			
			System.out.println(pesqVeiculo.getTipoVeiculo() + "\t" + pesqVeiculo.getChassi());
			
		}
		
		// Pesquisando veiculos com 2 atributo existente
		System.out.println("*********************************************************");
		System.out.println("Pesquisando veiculos com MONTADORA YAMAHA e CHASSI 000002");
		System.out.println("*********************************************************\n");
		System.out.println("TIPO\tCHASSI");
		for (Veiculo pesqVeiculo : loja.pesquisarVeiculo("MONTADORA=YAMAHA;CHASSI=000002;")) {
			
			System.out.println(pesqVeiculo.getTipoVeiculo() + "\t" + pesqVeiculo.getChassi());
			
		}
		
		// Pesquisando veiculos com 1 atributo não existente
		System.out.println("*********************************************************");
		System.out.println("Pesquisando veiculos com MONTADORA YAMAHA e CHASSI 000003");
		System.out.println("*********************************************************\n");
		System.out.println("TIPO\tCHASSI");
		for (Veiculo pesqVeiculo : loja.pesquisarVeiculo("MONTADORA=YAMAHA;CHASSI=000003;")) {
			
			System.out.println(pesqVeiculo.getTipoVeiculo() + "\t" + pesqVeiculo.getChassi());
			
		}
		
		loja.salvarEstoque("estoque.txt");

	}

}
