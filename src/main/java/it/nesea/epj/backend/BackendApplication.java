package it.nesea.epj.backend;

import it.nesea.epj.backend.entities.Ability;
import it.nesea.epj.backend.entities.Hero;
import it.nesea.epj.backend.services.AbilityService;
import it.nesea.epj.backend.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class BackendApplication {

	@Autowired
	private HeroService  heroService;

	@Autowired
	private AbilityService  abilityService;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {

			createHeroOnStartUp("superman","super-velocità","super-vista");
			createHeroOnStartUp("spiderman","sensi di ragno","super-agilità");
			createHeroOnStartUp("hulk","super-forza","furia");


		};
	}

	private void createHeroOnStartUp(String heroName,String... abilities){

		Hero hero = new Hero(heroName);

		for (String abilityName : abilities){
			Optional<Ability> abilityInMemory = abilityService.getAbilityByDescription(abilityName);
			if(abilityInMemory.isPresent()){
				hero.getAbilities().add(abilityInMemory.get());
			}
			else{
				hero.getAbilities().add(new Ability(abilityName));
			}
		}
		Optional<Hero> heroInMemory = heroService.getHeroByName(hero.getName());
		heroInMemory.ifPresent(hero1 -> hero.setId(hero1.getId()));
			heroService.addHero(hero);
	}

}
