package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;

// Nessa classe são definidos os métodos de persistência 

public interface RestauranteRepository {
	List<Restaurante> listar();
	Restaurante salvar(Restaurante restaurante);
	Restaurante buscar(Long id);
	void remover(Restaurante restaurante);
}
