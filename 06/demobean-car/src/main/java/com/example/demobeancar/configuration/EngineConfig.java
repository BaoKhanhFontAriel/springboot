package com.example.demobeancar.configuration;

import com.example.demobeancar.bean.Engine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class EngineConfig {

    @Bean
    @Primary
    public Engine gasEngine(){
        return new Engine("Gas Engine");
    }

    @Bean(name = "electricEngine")
    public Engine teslaEngine(){
        return new Engine("Testla Electric Engine");
    }

    @Bean(name = "hybridEngine")
    public Engine dongcoLai(){
        return new Engine("Hybrid Engine");
    }
}
