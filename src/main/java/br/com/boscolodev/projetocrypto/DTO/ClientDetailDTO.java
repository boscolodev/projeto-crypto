package br.com.boscolodev.projetocrypto.DTO;

public class ClientDetailDTO {

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
	public ClientDetailDTO() {

	}
	
	public ClientDetailDTO(Long id_Client, Long id_Carteira, Long id_Crypto) {

		this.id_Client = id_Client;
		this.id_Carteira = id_Carteira;
		this.id_Crypto = id_Crypto;

	}

	
	
	
}
