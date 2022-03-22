package br.com.boscolodev.projetocrypto.Class;

import java.util.Scanner;

import br.com.boscolodev.projetocrypto.DatabaseConnection.ConexaoMySQL;

//import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Integer opcao = 0;
		Crypto crypto = new Crypto();
		Client client = new Client();

		ConexaoMySQL.getConexaoMySQL();
		System.out.println(ConexaoMySQL.statusConexao());

		while (opcao != 5) {

			System.out.println("------ Menu ------");
			System.out.println("1 - Cadastrar Crypto Moedas");
			System.out.println("2 - Consultar Crypto por Nome");
			System.out.println("3 - Deletar Moeda Por ID");
			System.out.println("4 - Exibir Cryptos Cadastradas");
			System.out.println("5 - Sair");
			System.out.println("6 - Cadastro de Cliente");
			System.out.println("Escolha Opção Desejada: ");
			opcao = scan.nextInt();

			switch (opcao) {
			case 1: {
				crypto.cadastrarCrypto();
				break;
			}
			case 2: {
				crypto.pesquisarPorNome();
				break;
			}
			case 3: {
				crypto.deleteById();
				break;
			}
			case 4: {
				crypto.listarCrypto();
				break;
			}
			case 5: {
				scan.close();
				break;
			}
			case 6: {
				client.cadastrarClient();
				break;
			}
			case 7:{
				client.listarClient();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}

		}
	}

}
