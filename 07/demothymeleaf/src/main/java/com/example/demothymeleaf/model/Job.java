package com.example.demothymeleaf.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
    @NotBlank(message = "Email cannot null")
    @Email(message = "Not Valid Email")
    private String email;

    @NotBlank(message = "phone numbers cannot null")
    private String phoneNumbers;
}
