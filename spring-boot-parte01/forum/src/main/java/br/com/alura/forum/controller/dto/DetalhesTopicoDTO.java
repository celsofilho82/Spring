package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.model.StatusTopico;
import br.com.alura.forum.model.Topico;

public class DetalhesTopicoDTO {

	// Essa classe será utilizada para devolver com maior detalhes as informaçãoes
	// dos tópicos

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriação;
	private String nomeAutor;
	private StatusTopico status;
	private List<RespostasDTO> respostas;

	public DetalhesTopicoDTO(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriação = topico.getDataCriacao();
		this.nomeAutor = topico.getAutor().getNome();
		this.status = topico.getStatus();
		this.respostas = new ArrayList<RespostasDTO>();

		// Esse código transforma uma lista de respostas em uma lista de respostas DTO
		this.respostas.addAll(topico.getRespostas().stream().map(RespostasDTO::new).collect(Collectors.toList()));
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

	public String getNomeAutor() {
		return nomeAutor;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public List<RespostasDTO> getRespostas() {
		return respostas;
	}

}
