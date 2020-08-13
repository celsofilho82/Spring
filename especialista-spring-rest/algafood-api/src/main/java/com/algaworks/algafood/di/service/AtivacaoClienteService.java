package com.algaworks.algafood.di.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.TipoDoNotificador;

@Component
public class AtivacaoClienteService {
	
	//Usando a anotação customizada para definir um qualificador para a classe
	@TipoDoNotificador(NivelUrgencia.NORMAL)
	@Autowired
	private Notificador notificador;
	
	// Esse método será executado quando o bean for carregado
	@PostConstruct
	public void init() {
		System.out.println("INIT");
	}
	
	// Esse método será executado antes que o bean seja destruido
	@PreDestroy
	public void destroy() {
		System.out.println("DESTROY");
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();

		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}

}
