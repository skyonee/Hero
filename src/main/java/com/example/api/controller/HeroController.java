package com.example.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.api.dto.HeroDTO;
import com.example.api.mapper.HeroMapperDTO;
import com.example.application.services.HeroService;
import com.example.domain.exceptions.HeroNotExistException;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {
    @Autowired
    private HeroMapperDTO heroMapperDTO;

    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public ResponseEntity<Iterable<HeroDTO>> getHeroes() {
        return new ResponseEntity<>(this.heroMapperDTO.toHeroesDTO(this.heroService.getHeores()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeroDTO> getHero(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(this.heroMapperDTO.toHeroDTO(this.heroService.getHeroById(id)), HttpStatus.OK);
        } catch (HeroNotExistException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/contains/{value}")
    public ResponseEntity<Iterable<HeroDTO>> getHero(@PathVariable String value) {
        return new ResponseEntity<>(this.heroMapperDTO.toHeroesDTO(this.heroService.getHeroByNameContainsValue(value)),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HeroDTO> saveHero(@RequestBody HeroDTO newHero, @PathVariable Integer id) {
        var hero = this.heroMapperDTO.toHero(newHero);
        hero.setId(id);
        return new ResponseEntity<>(this.heroMapperDTO.toHeroDTO(heroService.saveHero(hero)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHero(@PathVariable Integer id) {
        try {
            this.heroService.deleteHeroById(id);
            return ResponseEntity.ok().build();
        } catch (HeroNotExistException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

