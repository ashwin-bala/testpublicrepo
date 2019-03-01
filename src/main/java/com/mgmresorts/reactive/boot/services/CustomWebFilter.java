package com.mgmresorts.reactive.boot.services;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFlux
public class CustomWebFilter implements WebFluxConfigurer {


	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**")
	            .addResourceLocations("/static", "classpath:/static/")
	            .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
	    }


}
