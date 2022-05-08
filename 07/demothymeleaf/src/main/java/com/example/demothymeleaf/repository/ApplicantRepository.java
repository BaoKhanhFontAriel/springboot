package com.example.demothymeleaf.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.example.demothymeleaf.model.Applicant;

import org.springframework.stereotype.Component;

@Component
public class ApplicantRepository {
    private List< Applicant> applicants;
    
    public ApplicantRepository(){
        applicants = new ArrayList<>();

        applicants.add(new Applicant("Khanh", "khanh home, ha noi", 25, false, "dai hoc kinh te quoc dan"));

        applicants.add(new Applicant("hoang", "hoang home, HCM", 21, true, "dai hoc kinh te HCM"));

        applicants.add( new Applicant("lan", "lan home, ha noi", 23, false, "cao dang ky thuat"));

        applicants.add(new Applicant("ha", "ha home, da nang", 26, false, "dai hoc nhan van"));
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }
}
