package com.example.api_gateway_service.api_gateway_service;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		Function<PredicateSpec, Buildable<Route>> routeFunction
			=p -> p.path("/get")
				    .uri("");
		return builder.routes()
				.route(p -> p.path("/CURRENCY-EXCHANGE-SERVICE/**")
					    .uri("lb://CURRENCY-EXCHANGE-SERVICE"))				
				.build();
	}

}
