package com.example.application.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.domain.exceptions.HeroNotExistException;
import com.example.domain.models.Hero;
import com.example.infrastructure.repository.HeroRepositoryH2Impl;

public class HeroServiceTest {
    private static final String Void = null;

    HeroRepositoryH2Impl heroRepositoryMock;

    HeroServiceImpl heroService;

    @Test
    void getHeroesTest() {
        initTest();

        Hero hero = new Hero();
        hero.setId(1);
        hero.setName("superman");
        List<Hero> listHero = new ArrayList<Hero>();
        listHero.add(hero);
        Iterable<Hero> heroes = listHero;

        when(this.heroRepositoryMock.getHeores()).thenReturn(heroes);

        Assertions.assertIterableEquals(heroService.getHeores(), heroes);
    }

    @Test
    void getHeroByIdTest() throws HeroNotExistException {
        initTest();

        Hero hero = new Hero();
        hero.setId(1);
        hero.setName("superman");

        when(this.heroRepositoryMock.isExistHero(hero.getId())).thenReturn(Boolean.TRUE);
        when(this.heroRepositoryMock.getHeroById(1)).thenReturn(Optional.of(hero));
        
        Assertions.assertEquals(heroService.getHeroById(1), hero);
    }

    @Test
    void getHeroByIdTestHeroNotExistException() throws HeroNotExistException {
        initTest();

        Hero hero = new Hero();
        hero.setId(1);
        hero.setName("superman");

        when(this.heroRepositoryMock.isExistHero(hero.getId())).thenReturn(Boolean.TRUE);
        when(this.heroRepositoryMock.getHeroById(1)).thenReturn(Optional.of(hero));
        
        Assertions.assertThrows(HeroNotExistException.class, () -> {
            this.heroService.getHeroById(2);
        });
    }

    @Test
    void getHeroesByNameContainsValueTest() {
        initTest();

        Hero hero = new Hero();
        hero.setId(1);
        hero.setName("superman");
        Hero hero2 = new Hero();
        hero2.setId(1);
        hero2.setName("batman");

        List<Hero> listHero = new ArrayList<Hero>();
        listHero.add(hero);
        listHero.add(hero2);
        Iterable<Hero> heroes = listHero;

        when(this.heroRepositoryMock.getHeores()).thenReturn(heroes);

        List<Hero> listHeroEnd = new ArrayList<Hero>();
        listHero.add(hero);
        Iterable<Hero> heroesEnd = listHeroEnd;

        Assertions.assertIterableEquals(heroService.getHeroByNameContainsValue("super"), heroesEnd);
    }

    @Test
    void updateHeroByIdTest() throws HeroNotExistException {
        initTest();

        Hero hero = new Hero();
        hero.setId(1);
        hero.setName("superman");

        when(this.heroRepositoryMock.isExistHero(hero.getId())).thenReturn(Boolean.TRUE);
        when(this.heroRepositoryMock.saveHero(hero)).thenReturn(hero);
        Assertions.assertEquals(heroService.updateHero(hero), hero);
    }

    @Test
    void updateHeroByIdTestHeroNotExistException() throws HeroNotExistException {
        initTest();

        Hero hero = new Hero();
        hero.setId(1);
        hero.setName("superman");

        when(this.heroRepositoryMock.isExistHero(hero.getId())).thenReturn(Boolean.FALSE);
        
        hero.setId(2);
        Assertions.assertThrows(HeroNotExistException.class, () -> {
            this.heroService.updateHero(hero);
        });
    }

    @Test
    void deleteHeroByIdTest() throws HeroNotExistException {
        initTest();

        Hero hero = new Hero();
        hero.setId(1);
        hero.setName("superman");

        when(this.heroRepositoryMock.isExistHero(hero.getId())).thenReturn(Boolean.TRUE);
        when(this.heroRepositoryMock.saveHero(hero)).thenReturn(hero);

        Assertions.assertEquals(heroService.updateHero(hero), hero);
    }

    @Test
    void deleteHeroByIdTestHeroNotExistException() throws HeroNotExistException {
        initTest();

        Hero hero = new Hero();
        hero.setId(1);
        hero.setName("superman");

        when(this.heroRepositoryMock.isExistHero(hero.getId())).thenReturn(Boolean.FALSE);

        Assertions.assertThrows(HeroNotExistException.class, () -> {
            this.heroService.updateHero(hero);
        });
    }

    void initTest() {
        this.heroRepositoryMock = mock(HeroRepositoryH2Impl.class);
        this.heroService = new HeroServiceImpl(heroRepositoryMock);
    }
}
