package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestaSomaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		/*
		 * Criando uma consulta que retorna a soma de todas as movimentações armazenadas
		 * no banco de dados
		 */

		String jpql_soma = "select sum(m.valor) from Movimentacao m";
		
		TypedQuery<BigDecimal> query_soma = em.createQuery(jpql_soma, BigDecimal.class);
		BigDecimal soma = query_soma.getSingleResult();
		System.out.println("Soma das movimentações: " + soma);

		/*
		 * Criando uma consulta que retorna a media de todas as movimentações armazenadas
		 * no banco de dados
		 */
		
		String jpql_media = "select avg(m.valor) from Movimentacao m";
		
		TypedQuery<Double> query_media = em.createQuery(jpql_media, Double.class);
		Double media = query_media.getSingleResult();
		System.out.println("Média das movimentações: " + media);
	}

}
