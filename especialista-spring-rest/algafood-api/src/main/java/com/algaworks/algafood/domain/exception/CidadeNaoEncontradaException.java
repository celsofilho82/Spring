package com.algaworks.algafood.domain.exception;

/*
 * Podemos utilizar a anotação @ResponseStatus para fazer com que uma exception quando lançada retorne um status HTTP
 */

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public CidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CidadeNaoEncontradaException(Long cidadeId) {
		this(String.format("Não existe um Estado com esse código %d", cidadeId));
	}
}
