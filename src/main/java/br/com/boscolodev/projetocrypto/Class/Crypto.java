package br.com.boscolodev.projetocrypto.Class;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crypto other = (Crypto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Crypto [id=" + id + ", rede=" + rede + ", sigla=" + sigla + "]";
	}

	public void cadastrarCrypto() {
		System.out.println("Digite o ID: ");
		id = scan.nextLong();
		System.out.println("Digite a Rede: ");
		rede = scan.next();
		System.out.println("Digite a Silga: ");
		sigla = scan.next();
		dt_cadastro = LocalDateTime.now();
		list.add(new Crypto(id, rede, sigla, dt_cadastro));
	}

	// Deleta moeda por ID
	public void deleteById() {
		System.out.println("Digite o Id para ser deletado: ");
		Long id = scan.nextLong();
		
		
		for (Crypto crypto : list) {

			if (crypto.getId().equals(id)) {

				System.out.println(crypto.toString());
				list.remove(crypto);
				

				System.out.println("Tentando Remover ID: " + id);

				System.out.println("Moeda: " + crypto.getSigla() + " removida com sucesso.");
				break;
			}
		}

	}

	// Pesquisa moeda por Sigla
	public void pesquisarPorNome() {
		System.out.println("Digite a Sigla para Pesquisa: ");
		String nome = scan.next();
		for (Crypto crypto : list) {

			if (nome.equals(crypto.getSigla()) == true) {
				System.out.println("ID: " + crypto.getId());
				System.out.println("Rede: " + crypto.getRede());
				System.out.println("Sigla: " + crypto.getSigla());
				System.out.println("Data: " + crypto.dt_cadastro);
			}

		}
	}

	public void listarCrypto() {
		for (Crypto crypto : list) {
			System.out.println("ID: " + crypto.id);
			System.out.println("Rede: " + crypto.rede);
			System.out.println("Sigla: " + crypto.sigla);
			System.out.println("Data Alteração: " + crypto.dt_cadastro);

		}

	}
}
