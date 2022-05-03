package com.example.di;

import java.util.function.Consumer;

import com.example.di.consumer.Consumerable;
import com.example.di.injector.EmailServiceInjector;
import com.example.di.injector.MessageServiceInjector;
import com.example.di.injector.SMSServiceInjector;
import com.example.di.service.MessageService;

public class MessgaeClientTest {
    public static void main(String[] args) {
        String message = "Hi from DI client";
        String email = "pachipachi@gmail.com";
        String phone = "12345669";
        MessageServiceInjector injector = null;
        Consumerable client = null;
        // send email
        injector = new EmailServiceInjector();
        client = injector.getConsumer();
        client.processMessage(message, email);
        // send SMS
        injector = new SMSServiceInjector();
        client = injector.getConsumer();
        client.processMessage(message, phone);
    }
}
