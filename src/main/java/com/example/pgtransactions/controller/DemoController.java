package com.example.pgtransactions.controller;

import com.example.pgtransactions.service.DemoService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DemoController {

	private final DemoService demoService;

	@PostMapping("/")
//	@Transactional -> works as expected
 	public Mono<Void> postEntities() {
		return demoService.doSomething();
	}
}
