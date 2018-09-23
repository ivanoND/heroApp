package it.nesea.epj.backend.controllers;

import it.nesea.epj.backend.entities.Hero;
import it.nesea.epj.backend.services.HeroService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/api/heroes")
    public JsonResponseBody getHeroes(){
            return new JsonResponseBody(HttpStatus.OK,heroService.getHeroes());
    }

    @GetMapping("/api/hero/{name}")
    public JsonResponseBody insertHero(@PathVariable("name") @Valid String name){
        return new JsonResponseBody(HttpStatus.OK,heroService.addHero(new Hero(name)));
    }

    @AllArgsConstructor
    private class JsonResponseBody{

        @Getter @Setter
        private HttpStatus status;

        @Getter @Setter
        private Object response;
    }
}
