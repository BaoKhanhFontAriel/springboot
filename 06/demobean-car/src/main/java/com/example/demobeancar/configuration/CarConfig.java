package com.example.demobeancar.configuration;

import com.example.demobeancar.bean.Car;
import com.example.demobeancar.bean.Engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CarConfig {
    @Autowired
    private ApplicationContext context;

    @Value("${engineType}")
    private String engineType;

    @Bean
    public Car car() {
        Engine engine;
        switch (engineType) {
            case "gas":
                engine = (Engine) context.getBean("gasEngine");
                break;
            case "electric":
                engine = (Engine) context.getBean("electricEngine");
                break;
            case "hybrid":
                engine = (Engine) context.getBean("hybridEngine");
                break;
            default:
                engine = (Engine) context.getBean("gasEngine");
        }

        return new Car(engine);
    }

    @Bean
    @Primary
    public Car funcar() {
        return new Car((Engine) context.getBean("hybridEngine"));
    }
}
