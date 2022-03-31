package br.com.boscolodev.projetocrypto.Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.boscolodev.projetocrypto.DAO.CryptoDAO;
import br.com.boscolodev.projetocrypto.DTO.CryptoDTO;

public class Crypto {

	@Autowired
	CryptoDAO cryptoDAO;
	
	private Long id;
	private String rede;
	private String sigla;
	private String dt_cadastro;
	Scanner scan = new Scanner(System.in);

	Date dataAtual = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String dataFormatada = dateFormat.format(dataAtual);
	
	List<CryptoDTO> list = new ArrayList<>();

	public Crypto() {
	}

	public Crypto(Long id, String rede, String sigla) {
		this.id = id;
		this.rede = rede;
		this.sigla = sigla;
		this.dt_cadastro = dataFormatada;
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
		System.out.println("Digite a Rede: ");
		rede = scan.nextLine();
		System.out.println("Digite a Silga: ");
		scan = new Scanner(System.in);
		sigla = scan.next();

		// Envio os dados para o DTO
		CryptoDTO cryptoDTO = new CryptoDTO(rede, sigla);

		// Cria um objeto DAO
		CryptoDAO cryptoDAO = new CryptoDAO();

		// Informa os dados para o SQL vindo do DTO
		cryptoDAO.insertCrypto(cryptoDTO);
	}

	// Deleta moeda por ID
	public void deleteById() {
		System.out.println("Digite o Id para ser deletado: ");
		scan = new Scanner(System.in);
		Long id = scan.nextLong();

		if (id != null) {

			cryptoDAO.deleteCrypto(id);
			System.out.println("Moeda removida com sucesso.");

		}
	}

	// Pesquisa moeda por Sigla
	public void pesquisarPorNome() {
		System.out.println("Digite a Sigla para Pesquisa: ");
		scan = new Scanner(System.in);
		String nome = scan.next();

		CryptoDAO cryptoDAO = new CryptoDAO();
		cryptoDAO.listByName(nome);

	}

	public void listarCrypto() {

		CryptoDAO cryptoDAO = new CryptoDAO();
		cryptoDAO.listAll();

	}

	public void updateById() {

		Long id = null;
		String rede = null;
		String sigla = null;

		scan = new Scanner(System.in);

		System.out.println("Digite o ID: ");
		id = scan.nextLong();
		System.out.println("Digite a REDE: ");
		rede = scan.next();
		System.out.println("Digite a Sigla: ");
		sigla  = scan.next();

		CryptoDAO cryptoDAO = new CryptoDAO();
		cryptoDAO.updateCrypto(id, rede, sigla);

	}
}
