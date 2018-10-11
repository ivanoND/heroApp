package it.nesea.epj.backend.controllers;

import it.nesea.epj.backend.entities.Ability;
import it.nesea.epj.backend.entities.Hero;
import it.nesea.epj.backend.services.AbilityService;
import it.nesea.epj.backend.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@org.springframework.web.bind.annotation.RestController
public class AbilityRestController {

    private final AbilityService abilityService;

    AbilityRestController(AbilityService abilityService){
        this.abilityService=abilityService;
    }
    @GetMapping("/api/abilities")
    public List<Ability> getAbilities(){
        return abilityService.getAbilities();
    }

    @GetMapping("/api/abilities/{heroId}")
    public List<Ability> getNoHeroAbilities(@Valid @PathVariable("heroId") long heroId){
        List<Ability> allAbilities = getAbilities();
        List<Ability> heroAbilities = abilityService.getHeroAbilities(heroId);

        allAbilities.removeAll(heroAbilities);
        return allAbilities;
    }

    @GetMapping("/api/ability/{id}")
    public Ability getAbility(@Valid @PathVariable("id") Long id){
        return abilityService.getAbilityById(id);
    }

    @PutMapping("/api/ability")
    public Ability updateAbility(@Valid @RequestBody Ability ability) {
        return abilityService.updateAbility(ability);
    }

    @DeleteMapping("/api/ability/{id}")
    public Ability deleteAbility(@Valid @PathVariable("id") long id){
        return abilityService.deleteAbilityById(id);
    }

    @PostMapping("/api/ability")
    public Ability addAbility(@Valid @RequestBody Ability ability){
        return this.abilityService.addAbility(ability);
    }
}
