package com.example.demothymeleaf.request;

import org.springframework.web.multipart.MultipartFile;


public record ApplicantRequest(
        String id, MultipartFile avatar,
        String name,
        int age, String address,
        String gender, String education,
        String email, String phoneNumbers) {

}
