package com.example.demobeancar.configuration;

import com.example.demobeancar.bean.AutoSteering;
import com.example.demobeancar.bean.ManualSteering;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SteeringConfig {

    @Bean
    public AutoSteering autosteering(){
        return new AutoSteering();
    }

    @Bean
    public ManualSteering manualsteering(){
        return new ManualSteering();
    }
}
