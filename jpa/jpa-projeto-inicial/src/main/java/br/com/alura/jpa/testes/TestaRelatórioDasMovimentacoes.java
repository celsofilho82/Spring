package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TestaRelatórioDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		/*
		 * Criando uma consulta que vai retornar um lista com todas as contas e desta
		 * lista vamos iterar para obter informações dessas contas.
		 * 
		 * Na JPA todos os relacionamento anotados com @ToMany são do tipo
		 * Lazy(preguiçoso)
		 * 
		 * Para evitar o problema do N+1 comum nos relacionamentos ToMany podemos
		 * solicitar ao Hibernate através do atributo join fetch que faz com que a
		 * consulta já traga os dados dos relacionamentos atrelados.
		 */

		String jpql = "select c from Conta c join fetch c.movimentacoes";
		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);

		List<Conta> contas = query.getResultList();

		for (Conta conta : contas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Numero: " + conta.getNumero());
			System.out.println("Agência: " + conta.getAgencia());
			System.out.println("Movimentacoes: " + conta.getMovimentacoes());
		}
	}
}
