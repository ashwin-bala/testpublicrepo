package com.mgmresorts.reactive.boot.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeAppController {
	@PostMapping("/post1")
	private Mono<String> updateEmployee(@RequestBody String employee) {
		System.out.println("---------EmployeeAppController - Reached this point----");
		return Mono.just(employee);

	    }
}
