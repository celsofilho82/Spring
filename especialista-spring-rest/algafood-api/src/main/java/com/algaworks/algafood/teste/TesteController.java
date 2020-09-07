package com.algaworks.algafood.teste;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

// Controller de teste para demonstrar a implementação consultas JPQL em repositórios

@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	@GetMapping("/cozinhas")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Cozinha> cozinhasPorNome(@RequestParam String nome) {
		return cozinhaRepository.findByNome(nome);
	}

	@GetMapping("/contem")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Cozinha> cozinhasContemNome(@RequestParam String nome) {
		return cozinhaRepository.findTodasByNomeContaining(nome);
	}

	@GetMapping("/restarantes/taxafrete")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Restaurante> restaurantesPorTaxafrete(@RequestParam 
			BigDecimal taxaInicial, BigDecimal taxaFinal) {
		return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
	}
}
