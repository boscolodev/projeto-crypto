package br.com.boscolodev.projetocrypto.Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import br.com.boscolodev.projetocrypto.DAO.CryptoDAO;
import br.com.boscolodev.projetocrypto.DTO.CryptoDTO;

public class Crypto {

	private Long id;
	private String rede;
	private String sigla;
	private String dt_cadastro;
	Scanner scan = new Scanner(System.in);

	List<CryptoDTO> list = new ArrayList<>();

	public Crypto() {
	}

	public Crypto(Long id, String rede, String sigla, String dt_cadastro) {
		this.id = id;
		this.rede = rede;
		this.sigla = sigla;
		this.dt_cadastro = dt_cadastro;
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

	public String getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(String dt_cadastro) {
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
		dt_cadastro = scan.next();
		
		//Envio os dados para o DTO
		CryptoDTO cryptoDTO = new CryptoDTO(rede, sigla, dt_cadastro);
		
		//Cria um objeto DAO
		CryptoDAO cryptoDAO = new CryptoDAO();
		
		//Informa os dados para o SQL vindo do DTO
		cryptoDAO.insertCrypto(cryptoDTO);
	}

	// Deleta moeda por ID
	public void deleteById() {
		System.out.println("Digite o Id para ser deletado: ");
		Long id = scan.nextLong();

		for (CryptoDTO cryptoDTO : list) {

			if (cryptoDTO.getId().equals(id)) {

				System.out.println(cryptoDTO.toString());
				list.remove(cryptoDTO);

				System.out.println("Tentando Remover ID: " + id);

				System.out.println("Moeda: " + cryptoDTO.getSigla() + " removida com sucesso.");
				break;
			}
		}

	}

	// Pesquisa moeda por Sigla
	public void pesquisarPorNome() {
		System.out.println("Digite a Sigla para Pesquisa: ");
		String nome = scan.next();
		for (CryptoDTO cryptoDTO : list) {

			if (nome.equals(cryptoDTO.getSigla()) == true) {
				System.out.println("ID: " + cryptoDTO.getId());
				System.out.println("Rede: " + cryptoDTO.getRede());
				System.out.println("Sigla: " + cryptoDTO.getSigla());
				System.out.println("Data: " + cryptoDTO.getDt_cadastro());
			}

		}
	}

	public void listarCrypto() {
		for (CryptoDTO cryptoDTO : list) {
			System.out.println("ID: " + cryptoDTO.getId());
			System.out.println("Rede: " + cryptoDTO.getDt_cadastro());
			System.out.println("Sigla: " + cryptoDTO.getSigla());
			System.out.println("Data Alteração: " + cryptoDTO.getDt_cadastro());

		}

	}
}
