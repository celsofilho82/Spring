package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

// Nessa classe são definidos os métodos de persistência 
@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
	
}
