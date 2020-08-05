package br.com.alura.forum.controller.dto;

public class TokenDto {

	private String token;
	private String tipoAuthenticacao;

	public TokenDto(String token, String string) {
		this.token = token;
		this.tipoAuthenticacao = string;
	}

	public String getToken() {
		return token;
	}

	public String getString() {
		return tipoAuthenticacao;
	}

}
