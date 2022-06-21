package com.kirks.wedding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.kirks.wedding")
public class WeddingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeddingSystemApplication.class, args);
	}

}
