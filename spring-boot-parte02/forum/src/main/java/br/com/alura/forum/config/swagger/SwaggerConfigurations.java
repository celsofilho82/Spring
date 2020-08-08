package br.com.alura.forum.config.swagger;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.alura.forum.modelo.Usuario;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// As configurações do Swagger devem ser feitas criando-se uma classe chamada SwaggerConfigurations e adicionando nela a anotação @Configuration;

@EnableSwagger2
@Configuration
public class SwaggerConfigurations {

	// Para configurar quais endpoints e pacotes da API o Swagger deve gerar a
	// documentação, devemos criar um método anotado com @Bean, que devolve um
	// objeto do tipo Docket;

	// Para acessar a documentação da API, devemos entrar no endereço
	// http://localhost:8080/swagger-ui.html;
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.alura.forum")).paths(PathSelectors.ant("/**")).build()
				.ignoredParameterTypes(Usuario.class).globalOperationParameters(
						Arrays.asList(new ParameterBuilder().name("Authorization").description("Header para Token JWT")
								.modelRef(new ModelRef("string")).parameterType("header").required(false).build()));
	}

}