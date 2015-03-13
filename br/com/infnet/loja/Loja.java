package br.com.infnet.loja;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.infnet.carro.TipoCarro;
import br.com.infnet.veiculos.carro.Especificacao;
import br.com.infnet.veiculos.moto.TipoMoto;

public class Loja extends Especificacao {

	Scanner input = new Scanner(System.in);

	String endereco;
	String nome;
	private ArrayList<TipoCarro> listaCarros = new ArrayList<>();
	private ArrayList<TipoMoto> listaMotos = new ArrayList<>();

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

	public void adicionarCarro() {
		TipoCarro tc = new TipoCarro();

		System.out.println("Entre com o chassi do carro:");
		String chassi = input.nextLine();
		tc.setChassi(chassi);

		System.out.println("Entre com a montadora:");
		String montadora = input.nextLine();
		tc.setMontadora(montadora);

		System.out.println("Entre com o modelo:");
		String modelo = input.nextLine();
		tc.setModelo(modelo);

		// tem q ser um enum
		System.out.println("Escolha o tipo:");
		String tipo = input.nextLine();
		tc.setTipo(tipo);

		// enum
		System.out.println("Entre com a cor do veiculo:");
		String color = input.nextLine();
		tc.setCor(color);

		System.out.println("Entre com preço do carro");
		double price = input.nextDouble();

		tc.setPreco(price);

		listaCarros.add(tc);

	}

	public void listar() {

		System.out.println("-----Listagem -----\n");

		for (TipoCarro tipoCarro : listaCarros) {

			System.out.println(listaCarros.size());
			System.out.println("Chassi: " + tipoCarro.getChassi());
			System.out.println("Montadora: " + tipoCarro.getMontadora());
			System.out.println("Modelo: " + tipoCarro.getModelo());
			System.out.println("Tipo: " + tipoCarro.getTipo());
			System.out.println("Cor: " + tipoCarro.getCor());
			System.out.println("Motorização: " + tipoCarro.getMotorizacao());
			System.out.println("Cambio: " + tipoCarro.getCambio());
			System.out.println("Preço: " + tipoCarro.getPreco());

			System.out.println();
		}

	}

	public void excluir() {

		System.out.println("Entre com ID a ser excluído:");
		int id = input.nextInt();
		listaCarros.remove(id);

	}

	public void gravar() {
		try {
			FileWriter arq = new FileWriter("D:\\arq.txt");
			PrintWriter gravarArq = new PrintWriter(arq);

			gravarArq.printf("+--Resultado--+%n");
			
			

			gravarArq.printf("\n+-------------+%n");

			arq.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
