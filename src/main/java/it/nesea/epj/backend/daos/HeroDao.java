package it.nesea.epj.backend.daos;

import it.nesea.epj.backend.entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroDao extends JpaRepository<Hero,Long> {

}
