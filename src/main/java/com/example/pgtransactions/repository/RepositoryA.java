package com.example.pgtransactions.repository;

import com.example.pgtransactions.domain.EntityA;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RepositoryA extends ReactiveCrudRepository<EntityA, Integer> {
}
