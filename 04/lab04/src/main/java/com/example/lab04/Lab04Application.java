package com.example.lab04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Lab04Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Lab04Application.class, args);
		Outfit outfit = context.getBean(Outfit.class);

		System.out.println("Instance: " + outfit);
		outfit.wear();
	}

}
