package br.com.boscolodev.projetocrypto.Class;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

public class Crypto {

	private String rede;
	private String sigla;
	private LocalDateTime dt_cadastro;

	public Crypto() {
	}

	public Crypto(String rede, String sigla, LocalDateTime dt_cadastro) {
		super();
		this.rede = rede;
		this.sigla = sigla;
		this.dt_cadastro = LocalDateTime.now();
	}

	public String getRede() {
		return rede;
	}

	public void setRede(String rede) {
		this.rede = rede;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public LocalDateTime getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(LocalDateTime dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}

	public void cadastrarCrypto() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite a Rede: ");
		System.out.println(scan.nextLine());
		System.out.println("Digite a Sigla: ");
		System.out.println(scan.nextLine());
		System.out.println(LocalDateTime.now());
		scan.close();
	}

	public void alterarCrypto(String rede, String sigla, LocalDateTime dt_Alteracao) {
		this.rede = rede;
		this.sigla = sigla;
		this.dt_cadastro = dt_Alteracao;
		System.out.println("Dados Alterados com Sucesso !");
		System.out.println("Rede: " + getRede());
		System.out.println("Sigla: " + getSigla());
		System.out.println("Data Alteração: " + getDt_cadastro());

	}

	public void consultarCrypto() {
		System.out.println("Dados Alterados com Sucesso !");
		System.out.println("Rede: " + getRede());
		System.out.println("Sigla: " + getSigla());
		System.out.println("Data Alteração: " + getDt_cadastro());
	}
}
