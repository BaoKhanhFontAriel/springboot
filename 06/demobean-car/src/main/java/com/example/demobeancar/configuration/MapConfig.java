package com.example.demobeancar.configuration;

import com.example.demobeancar.bean.StreetMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MapConfig {
    @Bean
    @Scope("prototype")
    public StreetMap streetMap(){
        return new StreetMap();
    }
}
