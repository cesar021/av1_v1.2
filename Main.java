import java.util.HashMap;
import java.util.Map;

import br.com.infnet.loja.Loja;
import br.com.infnet.veiculos.carro.Veiculo;

public class Main {

	public static void main(String[] args) {

		System.out.println("******************************************************");
		System.out.println("* Projeto de uma loja de ve�culos de uma grande rede *");
		System.out.println("******************************************************");

		System.out.println("");
		
		Loja loja = new Loja("GADS2014N", "Rua S�o Jos�, 90 - Centro, Rio de Janeiro - RJ, 20010-020");
		
		System.out.println("Loja    : " + loja.getNome());
		System.out.println("Endere�o: " + loja.getEndereco());
		
		System.out.println("Quantidade de ve�culo no estoque: " + loja.getEstoqueVeiculos().length);
		
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
		
		System.out.println("Quantidade de ve�culo no estoque: " + loja.getEstoqueVeiculos().length);
		
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
		
		// Listando todos os ve�culos do estoque
		loja.listarEstoquedeVeiculos(null);
		
		// Listando apenas os carros do estoque
		loja.listarEstoquedeVeiculos(TipoVeiculo.CARRO);
		
		// Listando apenas as motos do estoque
		loja.listarEstoquedeVeiculos(TipoVeiculo.MOTO);
	}

}
