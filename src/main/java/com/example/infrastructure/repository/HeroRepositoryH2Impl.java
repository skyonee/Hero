package com.example.infrastructure.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.models.Hero;
import com.example.domain.ports.HeroRepository;
import com.example.infrastructure.entity.HeroEntity;
import com.example.infrastructure.mapper.HeroMapper;

public class HeroRepositoryH2Impl implements HeroRepository {

    @Autowired
    private HeroMapper heroMapper;

    private final HeroJpaRepository heroJpaRepository;

    public HeroRepositoryH2Impl(HeroJpaRepository heroJpaRepository) {
        this.heroJpaRepository = heroJpaRepository;
    }

    @Override
    public Iterable<Hero> getHeores() {
        return this.heroMapper.toHeroes(this.heroJpaRepository.findAll());
    }

    @Override
    public Optional<Hero> getHeroById(Integer id) {
        HeroEntity hero = this.heroJpaRepository.getReferenceById(id);
        return Optional.of(this.heroMapper.toHero(hero));  
    }

    @Override
    public Iterable<Hero> getHeroByNameContainsValue(String value) {
        return this.heroMapper.toHeroes(this.heroJpaRepository.findByNameContaining(value));
    }

    @Override
    public Hero saveHero(Hero hero) {
        HeroEntity heroEntity = this.heroMapper.toHeroEnity(hero);
        return this.heroMapper.toHero(this.heroJpaRepository.save(heroEntity));
    }

    @Override
    public void deleteHeroById(Integer id) {
        HeroEntity heroEntity = this.heroJpaRepository.getReferenceById(id);
        this.heroJpaRepository.deleteById(heroEntity.getId());
    }

    @Override
    public Boolean isExistHero(Integer id) {
        return this.heroJpaRepository.existsById(id);
    }

}
