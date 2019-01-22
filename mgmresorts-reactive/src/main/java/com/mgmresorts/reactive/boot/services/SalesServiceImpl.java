package com.mgmresorts.reactive.boot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("salesService")
public class SalesServiceImpl implements ISalesService {

	@Override
	public List<String> ListSalesLeads() {
		List<String> list = new  ArrayList<String>(10);
		list.add("Uncle bob");
		list.add("Aunt Marry");
		list.add("Brother John");
		list.add("Sister Janet");
		list.add("Cousin Aaron");
		return list;
	}

}
