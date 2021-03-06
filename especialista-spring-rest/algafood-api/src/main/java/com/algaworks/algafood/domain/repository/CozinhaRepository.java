package com.algaworks.algafood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

// Refatorando a classe repository para obter os métodos de persistência 
// definidos na classe JpaRepository extendida

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

	List<Cozinha> findByNome(String nome);
	
	List<Cozinha> findTodasByNomeContaining(String nome);
	
	boolean existsByNome(String nome);
}
