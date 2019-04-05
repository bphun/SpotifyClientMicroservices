package com.bphan.spotifyrequestproxyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpotifyRequestProxyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotifyRequestProxyServiceApplication.class, args);
	}

}
