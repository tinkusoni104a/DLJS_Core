package com.jwlry.dljs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jwlry.dljs"})
public class DljsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DljsApplication.class, args);
	}

}
