package it.nesea.epj.backend.controllers;

import it.nesea.epj.backend.entities.Ability;
import it.nesea.epj.backend.entities.Hero;
import it.nesea.epj.backend.services.AbilityService;
import it.nesea.epj.backend.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@org.springframework.web.bind.annotation.RestController
public class HeroRestController {

    private final HeroService heroService;

    HeroRestController(HeroService heroService){
        this.heroService=heroService;
    }

    @GetMapping("/api/heroes")
    public ResponseEntity getHeroes() {
        return ResponseEntity.ok(heroService.getHeroes());
    }

    @PostMapping("/api/hero")
    public ResponseEntity addHero(@Valid @RequestBody Hero hero) {
        return ResponseEntity.ok(heroService.addHero(hero));
    }

    @DeleteMapping("/api/hero/{id}")
    public ResponseEntity deletHero(@Valid @PathVariable("id") long id) {
        return ResponseEntity.ok(heroService.deleteHeroById(id));
    }

    @GetMapping("/api/hero/{id}")
    public ResponseEntity getHero(@Valid @PathVariable("id") Long id) {

        Hero hero = heroService.getHeroById(id);
        if(hero==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hero);
    }

    @PutMapping("/api/hero")
    public ResponseEntity updateHero(@Valid @RequestBody Hero hero) {
        return ResponseEntity.ok(heroService.updateHero(hero));
    }

    @GetMapping("/api/hero/name")
    public ResponseEntity searchHeroes(@Valid @RequestParam("name") String name) {
        return ResponseEntity.ok(heroService.getHeroes()
                .stream()
                .filter(hero -> hero.getName().contains(name))
                .collect(Collectors.toList()));
    }
}
