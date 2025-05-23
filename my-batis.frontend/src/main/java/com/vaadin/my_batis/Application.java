package com.vaadin.my_batis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.vaadin.my_batis")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
