package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* In this class @SpringBootApplication annotation is used.
 * It is used to mark a configuration class that declares one or more @Bean methods and 
 * also triggers auto-configuration and component scanning.
 * It's same as declaring a class with @Configuration, @EnableAutoConfiguration and @ComponentScan annotations.*/
@SpringBootApplication
public class BackendFullProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendFullProjectApplication.class, args);
		System.out.println("server started!");
	}

}
