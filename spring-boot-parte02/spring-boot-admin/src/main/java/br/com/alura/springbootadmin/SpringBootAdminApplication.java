package br.com.alura.springbootadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

// Para utilizar o Spring Boot Admin, devemos criar um projeto Spring Boot e 
// adicionar nele os módulos spring-boot-starter-web e spring-boot-admin-server;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class SpringBootAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAdminApplication.class, args);
	}

}
