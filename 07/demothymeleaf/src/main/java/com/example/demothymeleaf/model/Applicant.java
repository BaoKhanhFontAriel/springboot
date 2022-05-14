package com.example.demothymeleaf.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {
    private String id;
    
    private MultipartFile avatar;

    @Size(min = 5, max = 30, message = "Name must between 5 and 30")
    private String name;

    @Min(value=18, message="must be equal or greater than 18")  
    @Max(value=45, message="must be equal or less than 45")  
    private int age;

    @NotBlank(message = "address cannot null")
    private String address;

    private String gender;

    @NotBlank(message = "education cannot null")
    private String education;
    
    @NotBlank(message = "Email cannot null")
    @Email(message = "Not Valid Email")
    private String email;

    @NotBlank(message = "phone numbers cannot null")
    private String phoneNumbers;
}
