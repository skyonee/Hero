package com.example.infrastructure.mapper;

import org.mapstruct.*;

import com.example.domain.models.Hero;
import com.example.infrastructure.entity.HeroEntity;

@Mapper(componentModel = "spring")
public interface HeroMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name")
    })
    Hero toHero(HeroEntity hero);
    Iterable<Hero> toHeroes(Iterable<HeroEntity> heroEntity);
    @InheritInverseConfiguration
    HeroEntity toHeroEnity(Hero hero);

}
