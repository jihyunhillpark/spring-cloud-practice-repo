package com.example.springcloudrouting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudRoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRoutingApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/first-service/**")
						.filters(f -> f.rewritePath("/first-service/(?<segment>.*)", "/${segment}"))
						.uri("http://localhost:8001"))
				.route(p -> p
						.path("/second-service/**")
						.filters(f -> f.rewritePath("/second-service/(?<segment>.*)", "/${segment}"))
						.uri("http://localhost:8002"))
				.build();
	}

}
