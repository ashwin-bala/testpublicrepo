package com.mgmresorts.reactive.boot.mgmresorts_reactive;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.mgmresorts.reactive.boot.controllers.EmployeeAppController;

@RunWith(SpringRunner.class)
@WebFluxTest(EmployeeAppController.class)
public class ControllerTest {
	@Autowired
    private WebTestClient webClient;
	

	 @Test
	 public void EmployeeSimpleControllerTest()
	   throws Exception {
		 System.out.println("--------Executing Employee Controller Test------");

		 webClient.post().uri("/employees/post1")
			.contentType(MediaType.APPLICATION_JSON)
			.body(BodyInserters.fromObject("Hello world - First Webflux controller test"))
			.exchange().expectStatus().isOk()
			.expectBody(String.class)
			.isEqualTo("Hello world - First Webflux controller test");	 
	        			
	 }
	 
	 
	


}
