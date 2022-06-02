package com.example.demothymeleaf.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRequest {
        private String name;
        private String address;
        private String email;
        private String phoneNumbers;
        private String businessActivities;
}
