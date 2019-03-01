package com.mgmresorts.reactive.boot.controllers;

import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class HomePageController {
	@GetMapping("/")
	  @ResponseBody
	  public Publisher<String> handler() {
	      return Mono.just("Hello world!");
	  }
}
