package br.com.alura.jpa.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titular;
	private Integer agencia;
	private Integer numero;
	private Double saldo;

	/*
	 * Informa que esse relacionamento já está mapeado pelo atributo conta. Com o
	 * mappepBy criamos um relacionamento bi-direcional entre as entidades na JPA
	 * evitando que ele crie duas vezes o relacionamento no banco(chave estrangeira
	 * e tabela de relacionamento).
	 * 
	 * Para mudar o comportamento de um relacionamento @ToMany que é do tipo Lazy,
	 * podemos usar o atributo fetch e definir o tipo de comportamento que quisermos
	 * para o relacionamentos. Nesse exemplo definimos que os dados devem ser
	 * carregados de forma antecipada FetchType.EAGER
	 */
	@OneToMany(mappedBy = "conta", fetch = FetchType.EAGER)
	private List<Movimentacao> movimentacoes;

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Movimentacao> getMovimentacoes() {

		return movimentacoes;
	}
}
