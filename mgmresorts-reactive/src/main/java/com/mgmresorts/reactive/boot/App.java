package com.mgmresorts.reactive.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * Hello world!
 *
 */

@EnableWebFlux
@SpringBootApplication
public class App 
{
	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("00000");
    }
}
