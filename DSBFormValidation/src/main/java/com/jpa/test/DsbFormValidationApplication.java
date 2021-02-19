package com.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.practice.controller"})
@SpringBootApplication
public class DsbFormValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsbFormValidationApplication.class, args);
	}

}
