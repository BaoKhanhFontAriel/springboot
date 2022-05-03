package com.example.di.injector;

import com.example.di.consumer.Consumerable;
import com.example.di.consumer.DIClient;
import com.example.di.service.EmailServiceImpl;
import com.example.di.service.MessageService;

public class EmailServiceInjector implements MessageServiceInjector{

    @Override
    public Consumerable getConsumer() {
        return new DIClient(new EmailServiceImpl());
    }
    
}
