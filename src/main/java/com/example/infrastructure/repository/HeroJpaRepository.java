package com.example.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.infrastructure.entity.HeroEntity;

public interface HeroJpaRepository extends JpaRepository<HeroEntity, Integer> {

    Iterable<HeroEntity> findByNameContaining(String value);

}
