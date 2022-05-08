package com.example.demothymeleaf.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demothymeleaf.model.Job;

public class JobRepository {
    private List<Job> jobs;

    public JobRepository(){
        jobs = new ArrayList<>();

        jobs.add(new Job("lập trình frontend", 1200, "lập trình front end", "Hanoi"));
        jobs.add(new Job("kế toán", 1000, "lập sổ sách kế toán cho công ty", "Hanoi"));
        jobs.add(new Job("designer", 1100, "thiết kế quảng cáo", "HCM"));
        jobs.add(new Job("content writer", 600, "viết nội dung quảng cáo sản phẩm", "HCM"));
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
