package com.example.pgtransactions.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoControllerTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void postTest() {
		webTestClient.post().uri("/").exchange().expectStatus().is5xxServerError();
	}

}