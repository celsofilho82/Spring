package com.algaworks.algafood.di.notificacao;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoDoNotificador {

	// Criamos uma anotação, qualificamos ela como a anotação @Qualifier e definimos
	// o tempo de retenção dela ou seja, por quanto tempo essa anotação é válida
	// neste caso durante o tempo de execução(RUNTIME)
	
	NivelUrgencia value();

}
