package it.nesea.epj.backend;

import it.nesea.epj.backend.entities.Ability;
import it.nesea.epj.backend.entities.Hero;
import it.nesea.epj.backend.services.HeroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	/**
	@Bean
	public CommandLineRunner demo(HeroService heroService) {
		return (args) -> {




		};
	}
	*/
}
