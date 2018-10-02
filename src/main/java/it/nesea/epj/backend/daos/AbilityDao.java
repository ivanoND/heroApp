package it.nesea.epj.backend.daos;

import it.nesea.epj.backend.entities.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface AbilityDao extends JpaRepository<Ability,Long> {

    Optional<Ability> findByDescription(String description);
    List<Ability> findByHeroesId(long heroId);
}
