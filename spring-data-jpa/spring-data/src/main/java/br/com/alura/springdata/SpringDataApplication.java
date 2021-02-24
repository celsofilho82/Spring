package br.com.alura.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.springdata.ORM.Cargo;
import br.com.alura.springdata.repository.CargoRepository;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	/*
	 * Um comando deve ser executado após o start da aplicação então implementamos a
	 * interface CommandLineRunner e o método run responsável pela execução
	 */

	@Autowired
	private CargoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cargo cargo = new Cargo();
		cargo.setDescricao("Desenvolvedor Java");
		repository.save(cargo);

	}

}
