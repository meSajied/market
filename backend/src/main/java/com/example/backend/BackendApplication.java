package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example.admin", "com.example.backend", "com.example.customer", "com.example.order", "com.example.product", "com.example.vendor"})
@EnableJpaRepositories(basePackages = {"com.example.admin", "com.example.backend", "com.example.customer", "com.example.order", "com.example.product", "com.example.vendor"})
@EntityScan(basePackages = {"com.example.admin", "com.example.backend", "com.example.customer", "com.example.order", "com.example.product", "com.example.vendor"})
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
