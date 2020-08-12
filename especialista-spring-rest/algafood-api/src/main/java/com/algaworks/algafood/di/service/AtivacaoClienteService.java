package com.algaworks.algafood.di.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.Notificador;

public class AtivacaoClienteService {

	// Neste exemplo temos uma interface Notificacao com duas implementações
	// NotificacaoSMS e NotificacaoEmail. Para resolver o problema da ambiquidade,
	// podemos passar para o spring uma lista de implementações de notificação e
	// fazer o uso para gerar uma notificação para cada implementação

	@Autowired
	private List<Notificador> notificadores;

	public void ativar(Cliente cliente) {
		cliente.ativar();

		for (Notificador notificador : notificadores) {
			notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
		}
	}

}
