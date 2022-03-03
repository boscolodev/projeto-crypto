package br.com.boscolodev.projetocrypto.Class;

import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Crypto crypto = new Crypto("Bitcoin","BTC",LocalDateTime.now());
		crypto.cadastrarCrypto();

		crypto.alterarCrypto("Cardano", "ADA", LocalDateTime.now());
		crypto.consultarCrypto();
	}

}
