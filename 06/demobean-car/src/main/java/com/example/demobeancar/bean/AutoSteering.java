package com.example.demobeancar.bean;

import com.example.demobeancar.interfaces.Steering;

public class AutoSteering implements Steering{

    @Override
    public String steer() {
        return "autosteering";
    }
}
