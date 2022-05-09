package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.model.Job;
import com.example.demothymeleaf.repository.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class JobController {
    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/add-job")
    public String showJobForm(Model model) {
        model.addAttribute("job", new Job());
        return "add-job";
    }

    @PostMapping("/add-job")
    public String addNewJob(@ModelAttribute Job job,
            Model model,
            RedirectAttributes redirAttrs) {
        jobRepository.getJobs().add(job);
        model.addAttribute("job", job);
        redirAttrs.addFlashAttribute("message", "Sucessful Submission");
        return "redirect:/add-job";
    }

    @GetMapping("/jobs")
    public String showEmployerList(Model model) {
        model.addAttribute("jobs", jobRepository.getJobs());
        return "jobs";
    }
}
