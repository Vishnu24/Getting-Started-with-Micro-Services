package com.tech.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TechEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechEurekaServerApplication.class, args);
	}
}
