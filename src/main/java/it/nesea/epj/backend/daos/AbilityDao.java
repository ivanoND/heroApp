package it.nesea.epj.backend.daos;

import it.nesea.epj.backend.entities.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityDao extends JpaRepository<Ability,Long> {
}
