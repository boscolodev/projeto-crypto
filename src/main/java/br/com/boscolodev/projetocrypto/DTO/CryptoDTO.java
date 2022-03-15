package br.com.boscolodev.projetocrypto.DTO;


public class CryptoDTO {

	private Long id;
	private String rede;
	private String sigla;
	private String dt_cadastro;
	
	public CryptoDTO() {
		
	}
	
	public CryptoDTO(String rede, String sigla, String dt_cadastro) {
		
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
	public void setDt_cadastro(String string) {
		this.dt_cadastro = string;
	}
	public Long getId() {
		return id;
	}
	

}
