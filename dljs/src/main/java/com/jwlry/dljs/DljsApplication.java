package com.jwlry.dljs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "DLJS API", version = "1.0.0.0", description = "Dhanlaxmi Jwellery System Core"))
//@SecurityScheme(name = "javainuseapi", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
//@EnableWebMvc
@SpringBootApplication
@ComponentScan(basePackages = { "com.jwlry.dljs" })
public class DljsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DljsApplication.class, args);
	}

}
