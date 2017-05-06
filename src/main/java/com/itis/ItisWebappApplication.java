package com.itis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.itis")
public class ItisWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItisWebappApplication.class, args);
	}
}
