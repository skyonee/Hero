package com.example.api.mapper;

import org.mapstruct.*;

import com.example.api.dto.HeroDTO;
import com.example.domain.models.Hero;

@Mapper(componentModel = "spring")
public interface HeroMapperDTO {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name")
    })
    HeroDTO toHeroDTO(Hero hero);
    Iterable<HeroDTO> toHeroesDTO(Iterable<Hero> heroes);
    @InheritInverseConfiguration
    Hero toHero(HeroDTO heroDTO);

}
