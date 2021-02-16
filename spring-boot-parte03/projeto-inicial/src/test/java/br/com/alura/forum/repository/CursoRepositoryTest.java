package br.com.alura.forum.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.modelo.Curso;
/*
 * Para testes com classes repository essas anotações precisam estar presentes:
 * @DataJpaTest - A anotação simplifica a escrita de testes automatizados de interfaces Repository.
 * @RunWith(SpringRunner.class) - A anotação serve para que o Spring inicialize o servidor e carregue os beans da aplicação durante a execução dos testes automatizados.
 */

@DataJpaTest
@RunWith(SpringRunner.class)
public class CursoRepositoryTest {

	/*
	 * Como esse é uma classe de teste do Spring é possível fazer a injeção de
	 * dependências.
	 */
	@Autowired
	private CursoRepository cursoRepository;

	@Test // pacote org.junit.Test
	@DisplayName("Deve retornar um curso ao buscar pelo seu nome")
	public void test() {
		String nomeCurso = "HTML 5";
		Curso curso = cursoRepository.findByNome(nomeCurso);

		Assert.assertNotNull(curso);
		Assert.assertEquals(nomeCurso, curso.getNome());

	}

	@Test
	@DisplayName("Deve retornar null para um curso que não está cadastrado")
	public void test2() {
		String nomeCurso = "JPA";
		Curso curso = cursoRepository.findByNome(nomeCurso);

		Assert.assertNull(curso);
	}

}
