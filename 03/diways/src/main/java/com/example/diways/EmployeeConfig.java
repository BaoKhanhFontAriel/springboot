package com.example.diways;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
    @Bean("employee1")
    public Employee employee(){
        return new Employee(1, "emp1", "email1");
    } 

    @Bean("employee2")
    public Employee employee2(){
        return new Employee(2, "emp2", "email2");
    } 
}
