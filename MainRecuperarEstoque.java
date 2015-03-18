import br.edu.infnet.Loja;
import br.edu.infnet.TipoVeiculo;


public class MainRecuperarEstoque {

	public static void main(String[] args) {
		
		System.out.println("******************************************************");
		System.out.println("* Projeto de uma loja de ve�culos de uma grande rede *");
		System.out.println("******************************************************");

		System.out.println("");
		
		System.out.println("******************");
		System.out.println("Recuperando backup");
		System.out.println("******************\n");
		
		Loja loja = new Loja("estoque.txt");
		
		// Listando todos os ve�culos do estoque
		loja.listarEstoquedeVeiculos(null);
		
		// Listando apenas os carros do estoque
		loja.listarEstoquedeVeiculos(TipoVeiculo.CARRO);
		
		// Listando apenas as motos do estoque
		loja.listarEstoquedeVeiculos(TipoVeiculo.MOTO);
	}
	
}
