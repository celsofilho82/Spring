package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.model.Curso;
import br.com.alura.forum.model.Topico;

//Essa classe será responsável por devolver uma lista com todos os tópicos cadastrados

// @RestController Indica ao Spring que este controller é um Rest e de forma implicita 
// já adiciona a anotação @ResponseBody nos métodos da classe

// @ResponseBody Indicar ao Spring que o retorno do método deve ser devolvido
// como resposta sem isso, o controller encaminha a requisição a uma página JSP, ou Thymeleaf

// O Spring, por padrão, converte os dados no formato JSON, utilizando a biblioteca Jackson

@RestController
public class TopicosController {

	@RequestMapping("/topicos")
	public List<TopicoDTO> lista() {
		Topico topico = new Topico("Duvida", "Duvida com Spring", new Curso("Spring", "Programação"));

		return TopicoDTO.converter(Arrays.asList(topico, topico, topico));
	}

}
