package com.example.diways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    @Autowired
    @Qualifier("employee2")
    private Employee employee;

    public CompanyController() {
    }

    public CompanyController(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "CompanyController [employee =" + employee + "]";
    }

    @GetMapping("/")
    public String home(){
        return "Hello world";
    }

    @GetMapping("/test")
    public String companyDetail(){
        return this.toString();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    
}
