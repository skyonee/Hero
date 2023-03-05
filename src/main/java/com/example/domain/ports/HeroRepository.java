package com.example.domain.ports;

import java.util.Optional;

import com.example.domain.models.Hero;

public interface HeroRepository {
    Iterable<Hero> getHeores();
    Optional<Hero> getHeroById(Integer id);
    Iterable<Hero> getHeroByNameContainsValue(String value);
    Hero saveHero(Hero hero);
    void deleteHeroById(Integer id);
    Boolean isExistHero(Integer id);
}
