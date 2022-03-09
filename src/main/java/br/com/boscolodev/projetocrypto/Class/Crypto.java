package br.com.boscolodev.projetocrypto.Class;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Crypto {

	private Long id;
	private String rede;
	private String sigla;
	private LocalDateTime dt_cadastro;
	Scanner scan = new Scanner(System.in);
	
	List<Crypto> list = new ArrayList<>();

	public Crypto() {
	}

	public Crypto(Long id, String rede, String sigla, LocalDateTime dt_cadastro) {
		this.id = id;
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
		id += 1;
		System.out.println("Digite a Rede: "); rede = scan.next();
		System.out.println("Digite a Silga: "); sigla = scan.next();
		dt_cadastro = LocalDateTime.now();
		
		list.add(new Crypto(id, rede, sigla, dt_cadastro));
	}

	public void alterarCrypto(String rede, String sigla, LocalDateTime dt_Alteracao) {

	}

	public void consultarCrypto() {

	}
}
