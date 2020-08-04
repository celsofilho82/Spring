package br.com.alura.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

// @EnableSpringDataWebSupport: Com essa anotação habilitamos esse suporte o Spring pegar da requisição, dos parâmetros da url os campos, 
// as informações de paginação e ordenação, e repassar isso para o Spring data. 

// @EnableCaching: Com essa anotação habilitamos o uso de cache pelo spring.

@EnableCaching
@EnableSpringDataWebSupport
@SpringBootApplication
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

}
