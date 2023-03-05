package com.example.infrastructure.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "heroes")
@Data
public class HeroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;    
}
