package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.model.Applicant;
import com.example.demothymeleaf.repository.ApplicantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ApplicantController {
    
    @Autowired
    private ApplicantRepository applicantRepository;

    @GetMapping("/add-applicant")
    public String showEmployerForm(Model model) {
        model.addAttribute("applicant", new Applicant());
        return "add-applicant";
    }

    @PostMapping("/add-applicant")
    public String addNewEmployer(@ModelAttribute Applicant applicant,
            Model model, 
            RedirectAttributes redirAttrs) {
        applicantRepository.getApplicants().add(applicant);
        model.addAttribute("applicant", applicant);
        redirAttrs.addFlashAttribute("message", "Sucessful Submission");
        return "redirect:/add-applicant";
    }

    @GetMapping("/applicants")
    public String showEmployerList(Model model) {
        model.addAttribute("applicants", applicantRepository.getApplicants());
        return "applicants";
    }
}
