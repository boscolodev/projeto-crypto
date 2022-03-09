package br.com.boscolodev.projetocrypto.Class;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Integer opcao = 0;
		Crypto crypto = new Crypto();
		
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
				crypto.cadastrarCrypto();
				break;
			}
			case 2: {
				break;
			}
			case 3: {
				break;
			}
			case 4: {
				crypto.listarCrypto();
				break;
			}
			case 5: {
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
			
			
		}
	}

}
