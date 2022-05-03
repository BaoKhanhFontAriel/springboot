package com.example.di.service;

public class EmailServiceImpl implements MessageService{

    @Override
    public void sendMessage(String message, String receiver) {
        System.out.println("Email sent to " + receiver + " with message: " + message);
        
    }
    
}
