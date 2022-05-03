package com.example;

public class Client {
    private EmailService emailService = new EmailService();
    public void processMessages(String message, String receiver){
        emailService.sendMail(message, receiver);
    }
}
