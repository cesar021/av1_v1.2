package br.com.infnet.veiculos.carro;

import java.util.Scanner;

import br.com.infnet.loja.Loja;
/*
 * Na classe veiculo usar tipo propriedade
 * especificacao vira concreto, usar mapas p eliminar tipoCarro e tipoMoto.
 * 
 * 
 * 
 * */
public class Principal {

	public static void main(String[] args) {

		Loja nc = new Loja();
		Scanner input = new Scanner(System.in);

		System.out.println("Entre com um valor: ");
		System.out.println("1: para adicionar um carro");
		System.out.println("2 para listar carros");
		System.out.println("3 para excluir por id");
		
		int op;
		op = input.nextInt();

		while (op != 0) {
			switch (op) {
			case 1:
				nc.adicionarCarro();

				break;

			case 2:
				nc.listar();
				break;
			case 3:
				nc.excluir();
				break;
			case 4:
				nc.gravar();
				break;

			default:
				System.out.println("Opção inválida");
				break;
			}
			
			System.out.println("Entre com um valor: ");
			System.out.println("1: para adicionar um carro");
			System.out.println("2 para listar carros");
			op = input.nextInt();

		}

	}

}
