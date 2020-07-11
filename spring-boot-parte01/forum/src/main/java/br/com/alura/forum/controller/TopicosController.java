package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.TopicoRepository;

//Essa classe será responsável por devolver uma lista com todos os tópicos cadastrados

// @RestController Indica ao Spring que este controller é um Rest e de forma implicita 
// já adiciona a anotação @ResponseBody nos métodos da classe

// @ResponseBody Indicar ao Spring que o retorno do método deve ser devolvido
// como resposta sem isso, o controller encaminha a requisição a uma página JSP, ou Thymeleaf

// O Spring, por padrão, converte os dados no formato JSON, utilizando a biblioteca Jackson 

// @Autowired fazendo a injeção de dependência na classe controller

// Na implementação do Spring Data JPA é possível criar consultas que filtram por atributos 
// da entidade, devemos seguir o padrão de nomenclatura de métodos do Spring, como por exemplo findByCursoNome

@RestController
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;

	@RequestMapping("/topicos")
	public List<TopicoDTO> lista(String nomeCurso) {

		if (nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDTO.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDTO.converter(topicos);
		}

	}

}
