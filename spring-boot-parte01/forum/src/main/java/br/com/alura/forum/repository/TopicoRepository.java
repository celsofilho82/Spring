package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.model.Topico;

// Essa interface tem o objetivo de abstrair o acesso ao banco de dados para a entidade Topico
// A interface herda de uma outra interface JpaRepository onde devemos informar:
// T: Quem é a Entidade(topico)
// ID: Qual o tipo do atributo da chave primária dessa entidade

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	List<Topico> findByCursoNome(String nomeCurso);
}
