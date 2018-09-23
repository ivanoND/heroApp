package it.nesea.epj.backend.services;

import it.nesea.epj.backend.entities.Hero;
import java.util.List;
import java.util.Optional;

public interface HeroService {

    List<Hero> getHeroes();

    Hero getHeroById(long id);

    Hero deleteHeroById(long id);

    Hero addHero(Hero hero);

    Hero updateHero(Hero hero);
}
