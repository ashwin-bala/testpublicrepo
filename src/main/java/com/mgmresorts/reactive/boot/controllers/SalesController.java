package com.mgmresorts.reactive.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgmresorts.reactive.boot.services.ISalesService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/sales")
public class SalesController {
	
	@Autowired
	ISalesService salesService; 
	
	@PostMapping(path = "/post1", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	private Flux<String> listSales(@RequestBody String salesID) {
		Flux<String> saleLeads = salesService.ListSalesLeads();
		System.out.println("--------SalesController - Reached this point----");
		return saleLeads;
	}

}
