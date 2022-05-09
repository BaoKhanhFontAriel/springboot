package com.example.demothymeleaf.model;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Job {
    private String name;
    private String company;
    private int salary;
    private String description;
    private String location;
}
