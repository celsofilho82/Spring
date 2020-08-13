package com.algaworks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Component
public class AtivacaoClienteService {

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	public void ativar(Cliente cliente) {
		cliente.ativar();

		// Usando o padrão de projetos observer para notificar a classe
		// ClienteAtivadoEvent que um temos um evento de ativação de usuário
		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));

	}

}
