package com.example.pgtransactions.service;

import com.example.pgtransactions.domain.EntityA;
import com.example.pgtransactions.domain.EntityB;
import com.example.pgtransactions.repository.RepositoryA;
import com.example.pgtransactions.repository.RepositoryB;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DemoService {

	private final RepositoryA repositoryA;

	private final RepositoryB repositoryB;

//	@Transactional
	public Mono<Void> doSomething() {
		return internal();
	}

	@Transactional
	public Mono<Void> internal() {
		Mono<EntityA> clash = Mono.just(EntityA.builder().name("clash").build()).flatMap(repositoryA::save);
		Mono<EntityB> ok = Mono.just(EntityB.builder().name("ok").build()).flatMap(repositoryB::save);
		return ok.and(clash);
	}
}
