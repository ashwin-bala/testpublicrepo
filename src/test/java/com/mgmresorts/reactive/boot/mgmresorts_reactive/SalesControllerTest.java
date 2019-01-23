package com.mgmresorts.reactive.boot.mgmresorts_reactive;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.mgmresorts.reactive.boot.controllers.SalesController;
import com.mgmresorts.reactive.boot.services.SalesServiceImpl;

import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@WebFluxTest(SalesController.class)
public class SalesControllerTest {
static List<String> setupList = new  ArrayList<String>(10);

@Autowired
private WebTestClient webClient;

@MockBean
private SalesServiceImpl service;


	@BeforeClass
    public static void setup() throws Exception {
		setupList.add("Uncle bob");
		setupList.add("Aunt Marry");
		setupList.add("Brother John");
		setupList.add("Sister Janet");
		setupList.add("Cousin Aaron");
	}
	
	 @Test
	 public void SalesSimpleControllerTest()
	   throws Exception {
	      
		 System.out.println("--------Executing Sales Controller Test------");

		  BDDMockito.given(this.service.ListSalesLeads()).willReturn(setupList);

	  
		 webClient.post().uri("/sales/post1")
			.contentType(MediaType.APPLICATION_JSON)
			.body(BodyInserters.fromObject("Hello world - First Webflux controller test"))
			.exchange().expectStatus().isOk()
			.expectBody(List.class).isEqualTo(setupList);
	 }

}
