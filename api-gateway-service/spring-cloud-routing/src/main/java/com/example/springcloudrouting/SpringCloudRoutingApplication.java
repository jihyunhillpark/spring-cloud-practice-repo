package com.example.springcloudrouting;

import com.sun.net.httpserver.HttpExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudRoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRoutingApplication.class, args);
	}

	@Bean
	public HttpTraceRepository httpTraceRepository( ){
		return new InMemoryHttpTraceRepository();
	}
}
