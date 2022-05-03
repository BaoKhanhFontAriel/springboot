package com.example.di.consumer;

import com.example.di.service.MessageService;


public class DIClient implements Consumerable {
    private MessageService service;

    @Override
    public void processMessage(String message, String receiver) {
        service.sendMessage(message, receiver);
    }

    public DIClient() {
    }

    public DIClient(MessageService service) {
        this.service = service;
    }

    public MessageService getService() {
        return service;
    }

    public void setService(MessageService service) {
        this.service = service;
    }

    
}
