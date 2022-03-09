package br.com.boscolodev.projetocrypto.Class;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Integer opcao = 0;

		while (opcao != 5) {

			System.out.println("------ Menu ------");
			System.out.println("1 - Cadastrar Crypto Moedas");
			System.out.println("2 - Consultar Crypto por Nome");
			System.out.println("3 - Deletar Moeda Por ID");
			System.out.println("4 - Exibir Cryptos Cadastradas");
			System.out.println("5 - Sair");
			System.out.println("Escolha Opção Desejada: ");
			opcao = scan.nextInt();

			switch (opcao) {
			case 1: {

			}
			case 2: {
				Crypto crypto = new Crypto();
				crypto.cadastrarCrypto();

			}
			case 3: {

			}
			case 4: {

			}
			case 5: {

			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
		}
	}

}
