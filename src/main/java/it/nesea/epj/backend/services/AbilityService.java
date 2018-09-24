package it.nesea.epj.backend.services;

import it.nesea.epj.backend.entities.Ability;

import java.util.List;

public interface AbilityService {

    List<Ability> getAbilities();

    Ability getAbilityById(long id);

    Ability deleteAbilityById(long id);

    Ability addAbility(Ability ability);

    Ability updateAbility(Ability ability);
}
