package com.example.lab043;

import org.springframework.stereotype.Component;

@Component
public class Bikini implements Outfit {

    @Override
    public void wear() {
        System.out.println("dng mac bikini");
    }
    
}
