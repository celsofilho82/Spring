package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

// Nesta classe temos a implementação dos métodos de persistência 
// usando o padrão repository

public class RestauranteRepositoryJpa implements RestauranteRepository{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Restaurante> listar() {
		// listando todos os restaurantes do banco de dados
		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}

	@Transactional
	@Override
	public Restaurante salvar(Restaurante restaurante) {
		// Salvando um restaurante no banco de dados
		return manager.merge(restaurante);
	}

	@Override
	public Restaurante buscar(Long id) {
		// Listando um restaurante pelo seu id no banco de dados
		return manager.find(Restaurante.class, id);
	}

	@Transactional
	@Override
	public void remover(Restaurante restaurante) {
		// Removendo um restaurante no banco de dados
		restaurante = buscar(restaurante.getId());
		manager.remove(restaurante);
	}

}
