package it.nesea.epj.backend.services;

import it.nesea.epj.backend.daos.HeroDao;
import it.nesea.epj.backend.entities.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroDao heroDao;

    @Override
    public List<Hero> getHeroes() {
        return heroDao.findAll();
    }

    @Override
    public Optional<Hero> getHeroById(long id) {
        return heroDao.findOneById(id);
    }

    @Override
    public Hero deleteHeroById(long id) {
        Hero hero = heroDao.getOne(id);
        heroDao.deleteById(id);
        return hero;
    }

    @Override
    public Hero addHero(Hero hero) {
        heroDao.save(hero);
        return hero;
    }

    @Override
    public Hero updateHero(Hero hero) {
        heroDao.save(hero);
        return hero;
    }

    @Override
    public Optional<Hero> getHeroByName(String name) {
        return heroDao.findByName(name);
    }
}
