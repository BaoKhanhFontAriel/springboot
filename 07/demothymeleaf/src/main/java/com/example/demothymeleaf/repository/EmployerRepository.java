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
        employers.put(id1, new Employer(id1, "ABC Software", "ngỗ 11, lê thanh nghị, hoàng mai, hà nội", "ourtsourcing", "abcsoftware@gmail.com", "01234569"));

        String id2 = UUID.randomUUID().toString();
        employers.put(id2, new Employer(id1, "Thanh Software", "ngỗ 11, lê thanh nghị, hoàng mai, hà nội", "ourtsourcing", "thanhsoftware@gmail.com", "01234569"));

        String id3 = UUID.randomUUID().toString();
        employers.put(id3, new Employer(id1, "Hung Software", "ngỗ 11, lê thanh nghị, hoàng mai, hà nội", "ourtsourcing", "hungsoftware@gmail.com", "01234569"));

        String id4 = UUID.randomUUID().toString();
        employers.put(id4, new Employer(id1, "Linhlinh Software", "ngỗ 11, lê thanh nghị, hoàng mai, hà nội", "ourtsourcing", "linhlinhsoftware@gmail.com", "01234569"));
    }

    public ConcurrentHashMap<String, Employer> getEmployers() {
        return employers;
    }
}
