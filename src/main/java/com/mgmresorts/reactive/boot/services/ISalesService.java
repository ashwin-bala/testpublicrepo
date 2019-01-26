package com.mgmresorts.reactive.boot.services;

import reactor.core.publisher.Flux;


public interface ISalesService {
	public Flux<String> ListSalesLeads();
}
