package it.nesea.epj.backend.services;

import it.nesea.epj.backend.daos.HeroDao;
import it.nesea.epj.backend.entities.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroDao heroDao;

    @Override
    public List<Hero> getHeroes() {
        return heroDao.findAll();
    }

    @Override
    public Hero getHeroById(long id) {
        return heroDao.getOne(id);
    }

    @Override
    public void deleteHeroById(long id) {
        heroDao.deleteById(id);
    }

    @Override
    public Hero addHero(Hero hero) {
        heroDao.save(hero);
        return hero;
    }

    @Override
    public void updateHero(Hero hero) {
        heroDao.save(hero);
    }
}
