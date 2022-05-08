package com.example.demothymeleaf.repository;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.example.demothymeleaf.model.Employer;

import org.springframework.stereotype.Component;

@Component
public class EmployerRepository {

    private ConcurrentHashMap<String, Employer> employers;

    public EmployerRepository(){
        employers = new ConcurrentHashMap<>();

        String id1 = UUID.randomUUID().toString();
        employers.put(id1, new Employer(id1, "ABC Software", "ngỗ 11, lê thanh nghị, hoàng mai, hà nội", "ourtsourcing"));

        String id2 = UUID.randomUUID().toString();
        employers.put(id2, new Employer(id1, "ABC Software", "ngỗ 11, lê thanh nghị, hoàng mai, hà nội", "ourtsourcing"));

        String id3 = UUID.randomUUID().toString();
        employers.put(id3, new Employer(id1, "ABC Software", "ngỗ 11, lê thanh nghị, hoàng mai, hà nội", "ourtsourcing"));

        String id4 = UUID.randomUUID().toString();
        employers.put(id4, new Employer(id1, "ABC Software", "ngỗ 11, lê thanh nghị, hoàng mai, hà nội", "ourtsourcing"));
    }

    public ConcurrentHashMap<String, Employer> getEmployers() {
        return employers;
    }
}
