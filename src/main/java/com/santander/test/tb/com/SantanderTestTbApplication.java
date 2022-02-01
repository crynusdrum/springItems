package com.santander.test.tb.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SantanderTestTbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SantanderTestTbApplication.class, args);
	}

}
