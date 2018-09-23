package it.nesea.epj.backend.controllers;

import it.nesea.epj.backend.entities.Hero;
import it.nesea.epj.backend.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/api/heroes")
    public List<Hero> getHeroes() {
        return heroService.getHeroes();
    }

    @PostMapping("/api/hero")
    public Hero addHero(@RequestBody Hero hero) {
        return heroService.addHero(hero);
    }

    @DeleteMapping("/api/hero/{id}")
    public Hero deletHero(@PathVariable("id") long id) {
        return heroService.deleteHeroById(id);
    }

    @GetMapping("/api/hero/{id}")
    public Hero getHero(@PathVariable("id") Long id) {
        return heroService.getHeroById(id);
    }

    @PutMapping("/api/hero")
    public Hero updateHero(@RequestBody Hero hero) {
        return heroService.updateHero(hero);
    }

    @GetMapping("/api/hero/name")
    public List<Hero> searchHeroes(@RequestParam("name") String name) {
        return heroService.getHeroes()
                .stream()
                .filter(hero -> hero.getName().contains(name))
                .collect(Collectors.toList());
    }
}
