package com.example.demothymeleaf.controller;

import java.util.UUID;

import com.example.demothymeleaf.model.Employer;
import com.example.demothymeleaf.repository.EmployerRepository;
import com.example.demothymeleaf.request.EmployerRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployerController {

    @Autowired
    private EmployerRepository employerRepository;

    @GetMapping("/add-employer")
    public String showEmployerForm(Model model) {
        model.addAttribute("employerRequest", new EmployerRequest());
        return "add-employer";
    }

    @PostMapping("/add-employer")
    public String addNewEmployer(@ModelAttribute EmployerRequest employerRequest,
            Model model,
            RedirectAttributes redirAttrs) {
        String id = UUID.randomUUID().toString();
        employerRepository.getEmployers().put(id,
                new Employer(id, employerRequest.getName(), employerRequest.getAddress(),
                        employerRequest.getBusinessActivities(), employerRequest.getEmail(),
                        employerRequest.getPhoneNumbers()));
        model.addAttribute("employerRequest", employerRequest);
        redirAttrs.addFlashAttribute("message", "Sucessful Submission");
        return "redirect:/add-employer";
    }

    @GetMapping("/employers")
    public String showEmployerList(Model model) {
        model.addAttribute("employers", employerRepository.getEmployers());
        return "employers";
    }
}
