package br.com.boscolodev.projetocrypto.DTO;

public class ClientMasterDetailDTO {

	private ClientDTO clientDTO;
	private ClientDetailDTO clientDetailDTO;

	public ClientMasterDetailDTO() {

	}

	public ClientMasterDetailDTO(ClientDTO clientDTO, ClientDetailDTO clientDetailDTO) {
		this.clientDTO = clientDTO;
		this.clientDetailDTO = clientDetailDTO;
	}

	public ClientDTO getClientDTO() {
		return clientDTO;
	}

	public void setClientDTO(ClientDTO clientDTO) {
		this.clientDTO = clientDTO;
	}

	public ClientDetailDTO getClientDetailDTO() {
		return clientDetailDTO;
	}

	public void setClientDetailDTO(ClientDetailDTO clientDetailDTO) {
		this.clientDetailDTO = clientDetailDTO;
	}

	@Override
	public String toString() {
		return "ClientMasterDetailDTO [clientDTO=" + clientDTO + ", clientDetailDTO=" + clientDetailDTO + "]";
	}

	
	
}
