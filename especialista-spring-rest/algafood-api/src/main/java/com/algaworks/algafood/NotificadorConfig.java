package com.algaworks.algafood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.di.notificacao.NotificadorEmail;

@Configuration
public class NotificadorConfig {

	// Métodos responsável por instânciar e configurar um objeto NotificadorEmail
		@Bean
		public NotificadorEmail notificadorEmail() {
			NotificadorEmail notificador = new NotificadorEmail("smtp.algamail.com.br");
			notificador.setCaixaAlta(true);
				
			return notificador;
		}
}
