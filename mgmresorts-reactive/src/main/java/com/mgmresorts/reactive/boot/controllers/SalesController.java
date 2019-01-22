package com.mgmresorts.reactive.boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgmresorts.reactive.boot.services.ISalesService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/sales")
public class SalesController {
	
	@Autowired
	ISalesService salesService; 
	
	@PostMapping("/post1")
	private Mono<List>  listSales(@RequestBody String salesID) {
		List <String> saleLeads = salesService.ListSalesLeads();
		System.out.println("--------SalesController - Reached this point----");
		return Mono.just(saleLeads);
	}

}
