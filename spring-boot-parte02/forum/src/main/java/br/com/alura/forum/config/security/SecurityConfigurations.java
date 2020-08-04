package br.com.alura.forum.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Para habilitar e configurar o controle de autenticação e autorização 
// do projeto, devemos criar uma classe e anotá-la com @Configuration e @EnableWebSecurity;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
	// Quando habilitamos o Spring Security por padrão ele bloqueia todas as
	// requisições aos endpoints da API.

	@Autowired
	private AutenticacaoService autenticacaoService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Neste método configuramos o esquema de autenticação do spring security

		// auth.userDetailsService: informamos como parâmetro a classe que terá a logica
		// de autenticação da API

		// Devemos indicar ao Spring Security qual o algoritmo de hashing de senha que
		// utilizaremos na API, chamando o método passwordEncoder()
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Este método é responsável pelas configurações de autorização do spring
		// security

		// http.authorizeRequests(): definindo as regras de acesso aos endpoints da api
		// permitindo acesso ao endpoints públicos listar e detalhar.

		// O método anyRequest().authenticated() indica ao Spring Security para bloquear
		// todos os endpoints que não foram liberados anteriormente com o método
		// permitAll();

		// Para o Spring Security gerar automaticamente um formulário de login, devemos
		// chamar o método and().formLogin().

		http.authorizeRequests().antMatchers(HttpMethod.GET, "/topicos").permitAll()
				.antMatchers(HttpMethod.GET, "/topicos/*").permitAll().anyRequest().authenticated().and().formLogin();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// Este método é responsável pelas configurações de recuros staticos como
		// requisiçoes para arquivos css, js, imagens e etc

	}

}
