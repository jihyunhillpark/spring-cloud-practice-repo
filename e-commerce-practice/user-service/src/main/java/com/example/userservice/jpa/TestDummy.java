package com.example.userservice.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TestDummy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
