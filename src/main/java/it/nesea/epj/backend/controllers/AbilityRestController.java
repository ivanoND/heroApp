package it.nesea.epj.backend.controllers;

import it.nesea.epj.backend.entities.Ability;
import it.nesea.epj.backend.entities.Hero;
import it.nesea.epj.backend.services.AbilityService;
import it.nesea.epj.backend.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
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
    public ResponseEntity getAbilities(){
        return ResponseEntity.ok(this.abilityService.getAbilities());
    }

    @GetMapping("/api/abilities/{heroId}")
    public ResponseEntity getNoHeroAbilities(@Valid @PathVariable("heroId") long heroId){
        List<Ability> allAbilities = (List<Ability>) getAbilities().getBody();
        List<Ability> heroAbilities = this.abilityService.getHeroAbilities(heroId);

        allAbilities.removeAll(heroAbilities);
        return ResponseEntity.ok(allAbilities);
    }

    @GetMapping("/api/ability/{id}")
    public ResponseEntity getAbility(@Valid @PathVariable("id") Long id){
        Ability ability = this.abilityService.getAbilityById(id);
        if(ability==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ability);
    }

    @PutMapping("/api/ability")
    public ResponseEntity updateAbility(@Valid @RequestBody Ability ability) {
        return ResponseEntity.ok(this.abilityService.updateAbility(ability));
    }

    @DeleteMapping("/api/ability/{id}")
    public ResponseEntity deleteAbility(@Valid @PathVariable("id") long id){
        return ResponseEntity.ok(this.abilityService.deleteAbilityById(id));
    }

    @PostMapping("/api/ability")
    public ResponseEntity addAbility(@Valid @RequestBody Ability ability){
        return ResponseEntity.ok(this.abilityService.addAbility(ability));
    }
}
