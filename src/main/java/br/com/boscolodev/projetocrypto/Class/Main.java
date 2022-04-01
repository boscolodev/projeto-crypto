package br.com.boscolodev.projetocrypto.Class;

import java.util.Scanner;

import br.com.boscolodev.projetocrypto.DatabaseConnection.ConexaoMySQL;
import br.com.boscolodev.projetocrypto.Entities.Client;
import br.com.boscolodev.projetocrypto.Entities.Crypto;

//import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Integer opcao = -1;
		Crypto crypto = new Crypto();
		Client client = new Client();

		ConexaoMySQL.getConexaoMySQL();
		System.out.println(ConexaoMySQL.statusConexao());

		while (opcao != 0) {

			System.out.println("------ Menu ------");
			System.out.println("1 - Cadastrar Crypto Moedas");
			System.out.println("12 - Consultar Crypto por Nome");
			System.out.println("13 - Deletar Moeda por ID");
			System.out.println("14 - Atualizar moeda por Nome");
			System.out.println("15 - Exibir Todas Moedas Cadastradas");
			System.out.println("2 - Cadastro de Cliente");
			System.out.println("21 - Listar Todos Clientes e Cryptos");
			System.out.println("22 - Listar Clientes e Cryptos por ID");
			System.out.println("23 - Atualizar Clientes e Cryptos por ID");
			System.out.println("24 - Deletar Cryptos por ID");
			System.out.println("0 - Sair");


			System.out.println("Escolha Opção Desejada: ");
			opcao = scan.nextInt();

			switch (opcao) {
				case 1 -> crypto.cadastrarCrypto();
				case 12 -> crypto.pesquisarPorNome();
				case 13 -> crypto.deleteById();
				case 14 -> crypto.updateById();
				case 15 -> crypto.listarCrypto();
				case 2 -> client.cadastrarClient();
				case 21 -> client.listarClient();
				case 22 -> client.listClientByID();
				//case 23 -> client.updateById();
				case 24 -> client.deleteById();
				case 0 -> scan.close();
				default -> throw new IllegalArgumentException("Unexpected value: " + opcao);
			}

		}
	}

}
