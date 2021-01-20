package com.example.pgtransactions.repository;

import com.example.pgtransactions.domain.EntityB;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RepositoryB extends ReactiveCrudRepository<EntityB, Integer> {
}
