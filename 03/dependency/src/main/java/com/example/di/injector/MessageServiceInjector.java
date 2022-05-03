package com.example.di.injector;

import com.example.di.consumer.Consumerable;

public interface MessageServiceInjector {
    Consumerable getConsumer();
}
