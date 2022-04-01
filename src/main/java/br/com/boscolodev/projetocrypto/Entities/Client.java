package br.com.boscolodev.projetocrypto.Entities;

import java.util.Objects;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.boscolodev.projetocrypto.DAO.ClientDAO;
import br.com.boscolodev.projetocrypto.DAO.ClientDetailDAO;
import br.com.boscolodev.projetocrypto.DTO.ClientDTO;
import br.com.boscolodev.projetocrypto.DTO.ClientDetailDTO;

public class Client {

	Scanner scan = new Scanner(System.in);

	
	@Autowired
	ClientDTO clientDTO;
	
	@Autowired
	ClientDAO clientDAO;

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
		String nome1 = null;
		String option = null;
		Long idRetorno = 0L;

		scan = new Scanner(System.in);

		System.out.println("Digite o Nome: ");
		nome= scan.next();
		nome = nome.trim();

		System.out.println("Digite o Email: ");
		email = scan.next();
		System.out.println("Digite a Carteira: ");
		id_Carteira = scan.nextLong();
		System.out.println("Digite a Crypto: ");
		id_Crypto = scan.nextLong();

		// Envio os dados para o DTO Mestre
		ClientDTO clientDTO = new ClientDTO(nome, email, id_Carteira, id_Crypto);
		// Cria um objeto DAO
		ClientDAO clientDAO = new ClientDAO();
		// Informa os dados para o SQL vindo do DTO
		clientDAO.insertClient(clientDTO);

		// Long retorno = clientDAO.retornoIdClient(clientDTO);
		clientDAO.retornoIdClient(clientDTO);
		idRetorno = clientDAO.retornoIdClient(clientDTO);

		do {

			// ID da tabela Cliente para chave estrangeira da tabela detalhe
			System.out.println("Digite o ID da Crypto: ");
			id_Crypto = scan.nextLong();

			// Inicia um Objeto DTO Detalhe para a primeira informação
			ClientDetailDTO clientDetailDTO = new ClientDetailDTO(idRetorno, clientDTO.getId_Carteira(), id_Crypto);

			// Cria um Detalhe DAO
			ClientDetailDAO clientDetailDAO = new ClientDetailDAO();
			// Injeta o SQL com os dados do registro do detalhe

			clientDetailDAO.insertDetail(clientDetailDTO);

			System.out.println("Desejar Inserir Alguma Crypto Moeda em Sua Carteira ? (s/n)");
			scan = new Scanner(System.in);
			option = scan.next();

		} while (option == "s");
		System.out.println("Opção do Scanner: " + option);
	}

	public void listarClient() {
		clientDAO.listarClient();

	}

	public void listClientByID() {
		
		System.out.println("Digite o ID: ");
		id = scan.nextLong();	
		
		clientDAO.listarClientByID(id);
		
	}

	public void deleteById() {
		System.out.println("Digite o ID do Cliente: ");
		id = scan.nextLong();

		if (id != null){
			clientDAO.deleteClient(id);
			System.out.println("Cliente Removido com sucesso !");
		}

	}
}
