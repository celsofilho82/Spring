package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class TesteMediaDiariaMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		/*
		 * Criando uma consulta que retorna a media diaria das movimenta��es armazenadas
		 * no banco de dados.
		 * 
		 * Quando temos uma proje��o com mais de um coluna, podemos trabalhar com um
		 * array de object <Object[]> pois cada coluna � um tipo difetente de dado
		 * ent�o, precisamos te um tipo mais gen�rico para representar esse dado
		 * 
		 * Podemos tamb�m definir um tipo especifio nesse caso definimos uma classe
		 * MediaComData<MediaComData> para representar esse tipo de deixar de usuar o
		 * Array de Object. Um uso interesante � que podemos instanciar um objeto
		 * atr�ves de uma query JPQL
		 */

		String jpql_media = "select new \r\n"
				+ "br.com.alura.jpa.modelo.MediaComData(avg(m.valor), day(m.data), month(m.data)) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

		TypedQuery<MediaComData> query_media = em.createQuery(jpql_media, MediaComData.class);
		List<MediaComData> medias = query_media.getResultList();
		for (MediaComData resultado : medias) {
			System.out.println("M�dia di�ria das movimenta��es do dia " + resultado.getDia() + "/" + resultado.getMes()
					+ " � " + resultado.getMedia());
		}

	}

}
