package br.com.alura.forum.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/*
 * @WebMvcTest - Com essa anotação o spring só carrega as classes do pacote MVC. Utilizamos nos testes dos controllers
 * @AutoConfigureMockMvc - Para conseguir injetar o MockMvc na classe de testes e necessário anotá-la com @AutoConfigureMockMvc.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class AutenticacaoControllerTest {

	/*
	 * Injetando uma classe utilitária do spring para efetuar teste nos controllers
	 */

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Deve devolver 400 caso dados de autenticação estejam incorretos")
	public void test() throws Exception {
		URI uri = new URI("/auth");
		String json = "{\"email\":\"invalido@email.com\",\"senha\":\"123456\"}";
		/*
		 * Depois de criar a uri e o json devemos utilizar a classe MockMvc para
		 * contruir a requisição passando os parâmetros de uri, json, content type com o
		 * media type. E neste caso já podemos passar o que esperamos receber como
		 * retorno da requisição seja um código de status http, body da requisição
		 * dentre outros
		 */

		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400));

	}

}
