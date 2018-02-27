package com.tech.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class TechConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechConfigServerApplication.class, args);
	}
}
