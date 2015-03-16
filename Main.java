import br.edu.infnet.Cor;
import br.edu.infnet.Especificacao;
import br.edu.infnet.Loja;
import br.edu.infnet.Montadora;
import br.edu.infnet.Tipo;
import br.edu.infnet.TipoVeiculo;
import br.edu.infnet.Veiculo;
import br.edu.infnet.Cambio;



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
		
		veiculo.setEspecificacao(new Especificacao(Montadora.BMW, "X1", Tipo.SUV, Cor.PRETO, 2.0, Cambio.AUTOMATICO));
		
		loja.adicionarCarro(veiculo);
		
		System.out.println("Quantidade de veículo no estoque: " + loja.getEstoqueVeiculos().length);
	}

}
