package com.example.demothymeleaf.model;

import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employer {

    private String id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "address is mandatory")
    private String address;

    @NotBlank(message = "budienss activities are mandatory")
    private String businessActivities;
}
