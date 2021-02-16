package br.com.alura.forum.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.modelo.Curso;
/*
 * Para testes com classes repository essas anotações precisam estar presentes:
 * @DataJpaTest - A anotação simplifica a escrita de testes automatizados de interfaces Repository.
 * @RunWith(SpringRunner.class) - A anotação serve para que o Spring inicialize o servidor e carregue os beans da aplicação durante a execução dos testes automatizados.
 * @AutoConfigureTestDatabase(replace = Replace.NONE) - Utilizar essa anotação para que o Spring não considere que os testes devem sempre ser executados em um banco de dados em memória.
 * @ActiveProfiles("test") - Força carregar o profile de test e o spring vai buscar as configurações do banco no application-test.properties.
 */

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
public class CursoRepositoryTest {

	/*
	 * Como esse é uma classe de teste do Spring é possível fazer a injeção de
	 * dependências.
	 */
	@Autowired
	private CursoRepository cursoRepository;

	/*
	 * Criando uma instância do EntityManager no ambiente de teste para persistir
	 * dados em um banco de dados de teste vazio
	 */

	@Autowired
	private TestEntityManager testManager;

	@Test // pacote org.junit.Test
	@DisplayName("Deve retornar um curso ao buscar pelo seu nome")
	public void test() {
		String nomeCurso = "HTML 5";

		// Criando um curso e persistindo no banco de dados de teste
		Curso html5 = new Curso();
		html5.setNome(nomeCurso);
		html5.setCategoria("Programação");
		testManager.persist(html5);

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
