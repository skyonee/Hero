package com.example.infrastructure.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.application.services.HeroService;
import com.example.application.services.HeroServiceImpl;
import com.example.domain.ports.HeroRepository;

@Configuration
@EnableCaching
public class BeanHeroConfiguration {

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("heroes");
    }
    
    @Bean
    HeroService heroBeanService(final HeroRepository heroRepository){
        return new HeroServiceImpl(heroRepository);
    }
}
