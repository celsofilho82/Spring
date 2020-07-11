package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.CursoRepository;
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

// Adicionamos o @RequestMapping("/topicos") na classe e nos métodos só precisamos especificar qual verbo http o mesmo
// vai responder @GetMapping(GET) @PostMapping(POST)

// Criaremos uma classe chamada TopicoForm para encapsular a escrita dos dados no database usando nos métodos de escrita

// @RequestBody informa ao Spring que os parâmetros devem ser obtidos no corpo da requisição

// Usamos o ResponseEntity<TopicoDTO> para montar uma resposta a ser devolvida ao cliente da API

// UriComponentsBuilder utilizado pelo spring pra gerar a uri do recuros criado no método post

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	public List<TopicoDTO> lista(String nomeCurso) {

		if (nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDTO.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDTO.converter(topicos);
		}
	}

	@PostMapping
	public ResponseEntity<TopicoDTO> cadastrar(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);
		
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}
}
