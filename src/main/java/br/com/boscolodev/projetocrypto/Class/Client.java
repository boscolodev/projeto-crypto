package br.com.boscolodev.projetocrypto.Class;

import java.util.Objects;
import java.util.Scanner;

import br.com.boscolodev.projetocrypto.DAO.ClientDAO;
import br.com.boscolodev.projetocrypto.DTO.ClientDTO;

public class Client {

	Scanner scan = new Scanner(System.in);
	
	private Long id;
	private String nome;
	private String email;
	private Long id_Carteira;
	private Long id_Crypto;
	private String dt_Cadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId_Carteira() {
		return id_Carteira;
	}

	public void setId_Carteira(Long id_Carteira) {
		this.id_Carteira = id_Carteira;
	}

	public Long getId_Crypto() {
		return id_Crypto;
	}

	public void setId_Crypto(Long id_Crypto) {
		this.id_Crypto = id_Crypto;
	}

	public String getDt_Cadastro() {
		return dt_Cadastro;
	}

	public void setDt_Cadastro(String dt_Cadastro) {
		this.dt_Cadastro = dt_Cadastro;
	}

	public Client() {

	}

	public Client(String nome, String email, Long id_Carteira, Long id_Crypto, String dt_Cadastro) {

		this.nome = nome;
		this.email = email;
		this.id_Carteira = id_Carteira;
		this.id_Crypto = id_Crypto;
		this.dt_Cadastro = dt_Cadastro;
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
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}

	public void cadastrarClient() {
		System.out.println("Digite o Nome: ");
		nome = scan.next();
		System.out.println("Digite o Email: ");
		email = scan.next();
		System.out.println("Digite a Carteira: ");
		id_Carteira = scan.nextLong();
		System.out.println("Digite a Crypto: ");
		id_Crypto = scan.nextLong();
		

		// Envio os dados para o DTO
		ClientDTO clientDTO = new ClientDTO(nome, email, id_Carteira, id_Crypto);

		// Cria um objeto DAO
		ClientDAO clientDAO = new ClientDAO();


		// Informa os dados para o SQL vindo do DTO
		clientDAO.insertClient(clientDTO);
	}
	
	
}
