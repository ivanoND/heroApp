package it.nesea.epj.backend.services;

import it.nesea.epj.backend.entities.Hero;
import java.util.List;
import java.util.Optional;

public interface HeroService {

    List<Hero> getHeroes();

    Optional<Hero> getHeroById(long id);

    void deleteHeroById(long id);

    void addHero(Hero hero);

    void updateHero(Hero hero);
}
