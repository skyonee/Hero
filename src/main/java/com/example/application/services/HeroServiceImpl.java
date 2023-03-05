package com.example.application.services;

import java.util.Optional;

import com.example.domain.exceptions.HeroNotExistException;
import com.example.domain.models.Hero;

public class HeroServiceImpl implements HeroService {

    @Override
    public Iterable<Hero> getHeores() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHeores'");
    }

    @Override
    public Optional<Hero> getHeroById(Integer id) throws HeroNotExistException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHeroById'");
    }

    @Override
    public Iterable<Hero> getHeroByNameContainsValue(String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHeroByNameContainsValue'");
    }

    @Override
    public Hero saveHero(Hero hero) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveHero'");
    }

    @Override
    public void deleteHeroById(Integer id) throws HeroNotExistException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteHeroById'");
    }
    
}
