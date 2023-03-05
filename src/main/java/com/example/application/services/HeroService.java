package com.example.application.services;

import com.example.domain.exceptions.HeroNotExistException;
import com.example.domain.models.Hero;

public interface HeroService {
    Iterable<Hero> getHeores();
    Hero getHeroById(Integer id) throws HeroNotExistException;
    Iterable<Hero> getHeroByNameContainsValue(String value);
    Hero saveHero(Hero hero);
    Hero updateHero(Hero hero) throws HeroNotExistException;
    void deleteHeroById(Integer id) throws HeroNotExistException;
}
