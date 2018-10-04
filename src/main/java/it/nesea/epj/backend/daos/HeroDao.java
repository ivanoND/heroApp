package it.nesea.epj.backend.daos;

import it.nesea.epj.backend.entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroDao extends JpaRepository<Hero,Long> {

    Optional<Hero> findByName(String name);
}
