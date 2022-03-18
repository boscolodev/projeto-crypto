package br.com.boscolodev.projetocrypto.DTO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CryptoDTO {

	private Long id;
	private String rede;
	private String sigla;
	private String dt_cadastro;
	
	public CryptoDTO() {
		
	}
	
	public CryptoDTO(String rede, String sigla) {
		
        Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dateFormat.format(dataAtual);
				
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
	public void setDt_cadastro(String string) {
		this.dt_cadastro = string;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
