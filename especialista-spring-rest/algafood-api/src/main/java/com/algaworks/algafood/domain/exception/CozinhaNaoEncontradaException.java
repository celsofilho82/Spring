package com.algaworks.algafood.domain.exception;

/*
 * Podemos utilizar a anotação @ResponseStatus para fazer com que uma exception quando lançada retorne um status HTTP
 */

public class CozinhaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public CozinhaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CozinhaNaoEncontradaException(Long cozinhaId) {
		this(String.format("Não existe um Estado com esse código %d", cozinhaId));
	}
}
