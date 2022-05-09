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
public class Applicant {
    private String name;
    private String address;
    private int age;
    private Boolean sex;
    private String education;
    private String email;
    private String phoneNumbers;
}
