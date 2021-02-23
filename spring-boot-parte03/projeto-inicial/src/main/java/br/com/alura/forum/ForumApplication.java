package br.com.alura.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
@EnableSwagger2
public class ForumApplication {

	/*
	 * Para gerar um WAR da aplicação para ser executado em um sevlet container
	 * externo(ex: tomcat) devemos fazer as seguintes modificações: 
	 * Alteração no arquivo pom.xml 
	 * Aplicar herança na classe principal do projeto herdando da
	 * classe SpringBootServletInitializer
	 * Sobrescrever o método SpringApplicationBuilder que vai retornar a classe principal
	 * ForumApplication.class
	 */

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

}
