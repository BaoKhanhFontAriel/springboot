package com.example.di.injector;

import com.example.di.consumer.Consumerable;
import com.example.di.consumer.DIClient;
import com.example.di.service.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector{

    @Override
    public Consumerable getConsumer() {
        // TODO Auto-generated method stub
        return new DIClient(new SMSServiceImpl());
    }
    
}
