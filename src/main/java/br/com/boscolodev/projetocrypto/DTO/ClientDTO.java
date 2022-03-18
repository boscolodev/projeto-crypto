package br.com.boscolodev.projetocrypto.DTO;


import br.com.boscolodev.projetocrypto.Class.DataF;

public class ClientDTO {

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

	public ClientDTO(String nome, String email, Long id_Carteira, Long id_Crypto) {
		super();
		this.nome = nome;
		this.email = email;
		this.id_Carteira = id_Carteira;
		this.id_Crypto = id_Crypto;
		this.dt_Cadastro = DataF.dataFormatada();
	}

	public ClientDTO() {

	}

	@Override
	public String toString() {
		return "ClientDTO [id=" + id + ", nome=" + nome + ", email=" + email + ", id_Carteira=" + id_Carteira
				+ ", id_Crypto=" + id_Crypto + ", dt_Cadastro=" + dt_Cadastro + "]";
	}

}
