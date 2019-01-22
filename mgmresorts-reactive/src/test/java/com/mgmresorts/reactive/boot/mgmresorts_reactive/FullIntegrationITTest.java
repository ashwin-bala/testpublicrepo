package com.mgmresorts.reactive.boot.mgmresorts_reactive;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

public class FullIntegrationITTest {
	
	private static WebTestClient client;
	private static int port = 8080;
	static List<String> setupList = new  ArrayList<String>(10);

	
	@BeforeClass
    public static void setup() throws Exception {
		setupList.add("Uncle bob");
		setupList.add("Aunt Marry");
		setupList.add("Brother John");
		setupList.add("Sister Janet");
		setupList.add("Cousin Aaron");
		client =  WebTestClient.bindToServer()
         .baseUrl("http://localhost:" + port)
         .build();
	}
	
	 @Test
	 public void testWebTestClientWithServerURL() {
		 System.out.println("--------Executing Full IT Test------");

		 client.post().uri("/sales/post1").body(BodyInserters.fromObject("HelloWorld-Ashwin")).exchange().expectStatus().isOk().expectBody(List.class).isEqualTo(setupList);
	    }
	 
	 @Test
	 public void testWebTestClientWithServerURLWithJSONPath() {
		 System.out.println("--------Executing Full IT Test------");

		 client.post().uri("/sales/post1").body(BodyInserters.fromObject("HelloWorld-Ashwin")).exchange().expectStatus().isOk().expectBody().jsonPath("$.[0]").isEqualTo("Uncle bob");
	    }

}
