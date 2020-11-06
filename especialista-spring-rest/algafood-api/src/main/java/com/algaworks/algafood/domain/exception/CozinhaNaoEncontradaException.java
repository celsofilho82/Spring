package com.algaworks.algafood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Podemos utilizar a anotação @ResponseStatus para fazer com que uma exception quando lançada retorne um status HTTP
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CozinhaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public CozinhaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CozinhaNaoEncontradaException(Long cozinhaId) {
		this(String.format("Não existe um Estado com esse código %d", cozinhaId));
	}
}
