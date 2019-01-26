package com.mgmresorts.reactive.boot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service("salesService")
public class SalesServiceImpl implements ISalesService {

	@Override
	public Flux<String> ListSalesLeads() {
		List<String> list = new  ArrayList<String>(10);
		list.add("Uncle bob");
		list.add("Aunt Marry");
		list.add("Brother John");
		list.add("Sister Janet");
		list.add("Cousin Aaron");
		return Flux.fromIterable(list);
	}

}
