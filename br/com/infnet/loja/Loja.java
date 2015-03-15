package br.com.infnet.loja;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import br.com.infnet.veiculos.carro.Especificacao;

public class Loja extends Especificacao {

	Scanner input = new Scanner(System.in);

	String endereco;
	String nome;

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

	}

	public void listar() {

	}

	public void excluir() {

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
