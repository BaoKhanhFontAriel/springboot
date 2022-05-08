package com.example.demothymeleaf.model;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employer {
    private String id;
    private String name;
    private String address;
    private String businessActivities;
}
