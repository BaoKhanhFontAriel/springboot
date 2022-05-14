package com.example.demothymeleaf.service;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.example.demothymeleaf.exception.StorageException;
import com.example.demothymeleaf.model.Applicant;
import com.example.demothymeleaf.request.ApplicantRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class StorageService {
    
    @Value("${upload.path}")
    private String path;

    public void uploadFile(MultipartFile file, Applicant applicant) {
        if (file.isEmpty()) {
            throw new StorageException("Failed to store empty file");
        }
        String fileName = file.getOriginalFilename();
        

        try (var is = file.getInputStream()) {
            System.out.println(Paths.get(path + fileName));
            Files.copy(is, Paths.get(path + fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            var msg = String.format("Failed to store file %s", fileName);
            throw new StorageException(msg, e);
        }
    }
}
