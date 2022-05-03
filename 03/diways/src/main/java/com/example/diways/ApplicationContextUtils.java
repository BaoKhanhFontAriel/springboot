package com.example.diways;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtils implements ApplicationContextAware{
    private static  ApplicationContext context;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
    public static <T extends Object> T getBeans(Class<T> beanClass){
        return context.getBean(beanClass);
    } 

    public static ApplicationContext getApplicationContext(){
        return context;
    }
}
