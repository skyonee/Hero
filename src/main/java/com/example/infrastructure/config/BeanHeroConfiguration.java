package com.example.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.application.services.HeroService;
import com.example.application.services.HeroServiceImpl;
import com.example.domain.ports.HeroRepository;

@Configuration
public class BeanHeroConfiguration {
    @Bean
    HeroService heroBeanService(final HeroRepository heroRepository){
        return new HeroServiceImpl(heroRepository);
    }
}
