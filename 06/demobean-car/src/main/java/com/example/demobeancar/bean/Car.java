package com.example.demobeancar.bean;

import com.example.demobeancar.interfaces.Steering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @Autowired
    @Qualifier("manualsteering")
    private Steering steering;

    @Autowired
    @Lazy
    private StreetMap streetMap;

    private Engine engine;

    public Car(Engine engine){
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine.toString() + ", steering=" + steering.steer() + "]";
    }

    public String navigate() {
        return streetMap.getRoute();
     }
}
