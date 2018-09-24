package it.nesea.epj.backend.services;

import it.nesea.epj.backend.daos.AbilityDao;
import it.nesea.epj.backend.entities.Ability;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AbilityServiceImpl implements AbilityService {

    @Autowired
    AbilityDao abilityDao;

    @Override
    public List<Ability> getAbilities() {
        return abilityDao.findAll();
    }

    @Override
    public Ability getAbilityById(long id) {
        return abilityDao.getOne(id);
    }

    @Override
    public Ability deleteAbilityById(long id) {
        Ability ability = abilityDao.getOne(id);
        abilityDao.deleteById(id);
        return ability;
    }

    @Override
    public Ability addAbility(Ability ability) {
        return abilityDao.save(ability);
    }

    @Override
    public Ability updateAbility(Ability ability) {
        return abilityDao.save(ability);
    }
}
