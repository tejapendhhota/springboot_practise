package com.example.currency_exchange_service.currency_exchange_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/sample-api")
	@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
	@CircuitBreaker(name = "sample-api", fallbackMethod = "hardcodedResponse")
	//@RateLimiter
	//@Bulkhead
	public String sampleApi() {
		log.info("Call received");		
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:9999/test",String.class);
		return forEntity.getBody();  
	}
	
	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}

}
