package it.nesea.epj.backend.controllers;

import it.nesea.epj.backend.entities.Hero;
import it.nesea.epj.backend.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/api/heroes")
        public List<Hero> getHeroes(){
            return heroService.getHeroes();
    }
}
