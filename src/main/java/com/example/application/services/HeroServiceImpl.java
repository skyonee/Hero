package com.example.application.services;

import org.springframework.cache.annotation.Cacheable;

import com.example.domain.exceptions.HeroNotExistException;
import com.example.domain.models.Hero;
import com.example.domain.ports.HeroRepository;

public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;

    public HeroServiceImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    @Cacheable("heroes")
    public Iterable<Hero> getHeores() {
        return this.heroRepository.getHeores();
    }

    @Override
    public Hero getHeroById(Integer id) throws HeroNotExistException {
        if (!this.heroRepository.isExistHero(id))
            throw new HeroNotExistException("Heroe no encontrado con el siguiente ID: " + id);

        return this.heroRepository.getHeroById(id).get();
    }

    @Override
    @Cacheable("heroes")
    public Iterable<Hero> getHeroByNameContainsValue(String value) {
        return this.heroRepository.getHeroByNameContainsValue(value);
    }

    @Override
    public Hero saveHero(Hero hero) {
        return this.heroRepository.saveHero(hero);
    }

    @Override
    public void deleteHeroById(Integer id) throws HeroNotExistException {
        if (!this.heroRepository.isExistHero(id))
            throw new HeroNotExistException("Heroe no encontrado con el siguiente ID: " + id);

        this.heroRepository.deleteHeroById(id);
    }

    @Override
    public Hero updateHero(Hero hero) throws HeroNotExistException {
        if (!this.heroRepository.isExistHero(hero.getId()))
            throw new HeroNotExistException("Heroe no encontrado con el siguiente ID: " + hero.getId());

        return this.saveHero(hero);
    }

}
