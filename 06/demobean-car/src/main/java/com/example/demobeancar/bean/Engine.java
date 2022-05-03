package com.example.demobeancar.bean;

public class Engine {
    private String name;

    public Engine(String name) {
        this.name = name;
    }

    public String steer() {
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
