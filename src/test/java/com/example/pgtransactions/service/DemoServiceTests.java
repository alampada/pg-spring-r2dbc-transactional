package com.example.pgtransactions.service;

import com.example.pgtransactions.repository.RepositoryA;
import com.example.pgtransactions.repository.RepositoryB;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;

import org.springframework.context.annotation.Import;
import org.springframework.data.r2dbc.core.DatabaseClient;

@DataR2dbcTest
@Import(DemoService.class)
@Disabled
class DemoServiceTests {
	@Autowired
	private RepositoryA repositoryA;

	@Autowired
	private RepositoryB repositoryB;

	@Autowired
	DatabaseClient databaseClient;

	@Autowired
	private DemoService testObject;

	@Test
	public void testTransactionClash() {
		Mono<Void> voidMono = testObject.doSomething();

		StepVerifier.create(voidMono).expectError().verify();

		StepVerifier.create(repositoryB.findAll()).verifyComplete();
	}
}