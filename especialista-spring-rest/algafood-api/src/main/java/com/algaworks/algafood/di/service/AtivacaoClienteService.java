package com.algaworks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.Notificador;

public class AtivacaoClienteService {

	// Podemos configurar uma dependência opcional no projeto passando o parâmetro
	// (required = false) para a anotação @Autowired

	@Autowired(required = false)
	private Notificador notificador;

	public void ativar(Cliente cliente) {
		cliente.ativar();

		if (notificador != null) {
			notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
		} else {
			System.out.println("Não existe notificador, mas cliente foi ativado");
		}
	}

}
