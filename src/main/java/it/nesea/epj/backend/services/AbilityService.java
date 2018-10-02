package it.nesea.epj.backend.services;

import it.nesea.epj.backend.entities.Ability;
import it.nesea.epj.backend.entities.Hero;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AbilityService {

    List<Ability> getAbilities();

    Ability getAbilityById(long id);

    Optional<Ability> getAbilityByDescription(String description);

    Ability deleteAbilityById(long id);

    Ability addAbility(Ability ability);

    Ability updateAbility(Ability ability);

    List<Ability> getAbilitiesFromHeroId(long heroId);
}
