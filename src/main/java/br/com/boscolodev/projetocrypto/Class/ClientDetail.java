package br.com.boscolodev.projetocrypto.Class;

import java.util.Objects;
import java.util.Scanner;

import br.com.boscolodev.projetocrypto.DAO.ClientDetailDAO;
import br.com.boscolodev.projetocrypto.DTO.ClientDetailDTO;

public class ClientDetail {

	Scanner scan = new Scanner(System.in);

	private Long id;
	private Long id_Client;
	private Long id_Carteira;
	private Long id_Crypto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_Client() {
		return id_Client;
	}

	public void setId_Client(Long id_Client) {
		this.id_Client = id_Client;
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

	public ClientDetail() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, id_Carteira, id_Client, id_Crypto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientDetail other = (ClientDetail) obj;
		return Objects.equals(id, other.id) && Objects.equals(id_Carteira, other.id_Carteira)
				&& Objects.equals(id_Client, other.id_Client) && Objects.equals(id_Crypto, other.id_Crypto);
	}

	public void cadastrarDetail() {
		System.out.println("Digite o Cliente: ");
		id_Client = scan.nextLong();
		System.out.println("Digite a Carteira: ");
		id_Carteira = scan.nextLong();
		System.out.println("Digite a Crypto: ");
		id_Crypto = scan.nextLong();

		// Envio os dados para o DTO
		ClientDetailDTO clientDetailDTO = new ClientDetailDTO(id_Client, id_Carteira, id_Crypto);

		// Cria um objeto DAO
		ClientDetailDAO clientDetailDAO = new ClientDetailDAO();

		// Informa os dados para o SQL vindo do DTO
		clientDetailDAO.insertDetail(clientDetailDTO);

	}
}
