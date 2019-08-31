package com.CoffeeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.SpringSecurityCoreVersion;

@SpringBootApplication
		(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
		)
public class CoffeeZoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeZoneApplication.class, args);
	}

}
