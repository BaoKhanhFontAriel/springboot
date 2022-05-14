package com.example.demothymeleaf.controller;

import java.util.UUID;

import javax.validation.Valid;

import com.example.demothymeleaf.model.Applicant;
import com.example.demothymeleaf.repository.ApplicantRepository;
import com.example.demothymeleaf.request.ApplicantRequest;
import com.example.demothymeleaf.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ApplicantController {

    @Value("${upload.path}")
    private String path;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private StorageService storageService;

    @GetMapping("/add-applicant")
    public String showEmployerForm(Model model) {
        model.addAttribute("applicant", new Applicant());
        return "add-applicant";
    }

    @PostMapping(value = "/add-applicant", consumes = { "multipart/form-data" })
    public String addNewEmployer(@ModelAttribute ApplicantRequest applicantReq,
            Model model,
            RedirectAttributes redirAttrs, BindingResult bindingResult) {

        if (applicantReq.avatar().getOriginalFilename().isEmpty()) {
            bindingResult.addError(new FieldError("applicant", "avatar", "Photo is required"));
        }

        if (bindingResult.hasErrors()) {
            return "/add-applicant";
        }

        String id = UUID.randomUUID().toString();

        Applicant newApplicant = new Applicant(id,
                applicantReq.avatar(),
                applicantReq.name(),
                applicantReq.age(),
                applicantReq.address(),
                applicantReq.gender(),
                applicantReq.education(),
                applicantReq.email(),
                applicantReq.phoneNumbers());

        storageService.uploadFile(applicantReq.avatar(), newApplicant);

        applicantRepository.getApplicants().add(newApplicant);

        model.addAttribute("applicant", newApplicant);
        redirAttrs.addFlashAttribute("message",  applicantReq.avatar().getOriginalFilename());
        return "redirect:/add-applicant";
    }

    @GetMapping("/applicants")
    public String showEmployerList(Model model) {
        model.addAttribute("applicants", applicantRepository.getApplicants());
        return "applicants";
    }

}
