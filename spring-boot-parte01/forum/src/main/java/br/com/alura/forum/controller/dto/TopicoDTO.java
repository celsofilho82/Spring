package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.alura.forum.model.Topico;

public class TopicoDTO {

	// Essa classe utiliza o padrão de projeto DTO(Data Transfer Object) utilizado
	// para devolver no endpoint apenas algums atributos de uma classe de dominio.

	// Não é uma boa prática retornar entidades JPA nos métodos dos controllers,
	// sendo mais indicado retornar classes que seguem o padrão DTO

	// Neste tipo de classe só precisamos dos métodos Getters

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriação;

	public TopicoDTO(Topico topico) {
		// Quando instanciamos essa classe devemos receber no seu contrutuor um objeto
		// do tipo Topico

		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriação = topico.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriação() {
		return dataCriação;
	}

	public static List<TopicoDTO> converter(List<Topico> topicos) {
		// Este método converte uma lista de objetos do tipo Topico em uma outra lista
		// de objetos do tipo topicoDTO usando a API de stream do Java 8

		return topicos.stream().map(TopicoDTO::new).collect(Collectors.toList());
	}

}
