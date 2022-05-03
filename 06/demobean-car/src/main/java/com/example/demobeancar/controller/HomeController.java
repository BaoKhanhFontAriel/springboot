package com.example.demobeancar.controller;

import com.example.demobeancar.bean.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    Car myCar; // Lấy bean có tên là car

    @ResponseBody
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String getHome() {
        return myCar.toString();
    }

    @ResponseBody
    @GetMapping(value = "/route", produces = MediaType.TEXT_HTML_VALUE)
    public String getRoute() {
        return myCar.navigate();
    }
}
