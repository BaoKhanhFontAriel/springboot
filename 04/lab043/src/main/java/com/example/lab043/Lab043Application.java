package com.example.lab043;

import com.example.lab043.other_package.Dress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

@SpringBootApplication
@ComponentScan
// (basePackages = { "vn.techmaster.lab043" }
// , excludeFilters = @Filter(type = FilterType.ASPECTJ,  pattern = "vn.techmaster.lab043.other_package.*")
// )
public class Lab043Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Lab043Application.class, args);

		Bikini bikini = context.getBean(Bikini.class);
		System.out.println("Bikini: " + bikini);

		Dress dress = context.getBean(Dress.class);
		System.out.println("Dress: " + dress);
	}

}
