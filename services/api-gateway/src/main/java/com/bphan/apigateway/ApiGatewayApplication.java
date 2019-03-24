package com.bphan.apigateway;

import com.bphan.apigateway.Filters.ErrorFilter;
import com.bphan.apigateway.Filters.PostFilter;
import com.bphan.apigateway.Filters.PreFilter;
import com.bphan.apigateway.Filters.RouteFilter;
import com.bphan.apigateway.Security.JwtConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public PreFilter getPreFilter() {
		return new PreFilter();
	}

	@Bean
	public RouteFilter getRouteFilter() {
		return new RouteFilter();
	}

	@Bean
	public ErrorFilter getErrorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public PostFilter getPostFilter() {
		return new PostFilter();
	}

	@Bean
	public JwtConfig getJwtConfig() {
		return new JwtConfig();
	}
	
}
