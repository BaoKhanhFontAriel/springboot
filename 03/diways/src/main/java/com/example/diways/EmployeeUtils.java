package com.example.diways;
public class EmployeeUtils {
    public static Employee getEmployeeBean(){
        return ApplicationContextUtils.getBeans(Employee.class);
    }
}
