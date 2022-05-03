package com.example.lab043.other_package;

import com.example.lab043.Outfit;

import org.springframework.stereotype.Component;

@Component
public class Dress implements Outfit {

    @Override
    public void wear() {
        System.out.println("Đang mặc váy");
    }
    
}
