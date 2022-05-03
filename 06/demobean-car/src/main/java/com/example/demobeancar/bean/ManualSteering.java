package com.example.demobeancar.bean;

import com.example.demobeancar.interfaces.Steering;

public class ManualSteering implements Steering{

    @Override
    public String steer() {
        return "ManualSteering";
    }
}
