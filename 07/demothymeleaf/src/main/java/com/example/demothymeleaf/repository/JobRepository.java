package com.example.demothymeleaf.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demothymeleaf.model.Job;

import org.springframework.stereotype.Component;

@Component
public class JobRepository {
    private List<Job> jobs;

    public JobRepository(){
        jobs = new ArrayList<>();

        jobs.add(new Job("lập trình frontend", "FShop",1200, "lập trình front end", "Hanoi", "abcsoftware@gmail.com", "01234569"));
        jobs.add(new Job("kế toán","Mount Inc", 1000, "lập sổ sách kế toán cho công ty", "Hanoi", "abcsoftware@gmail.com", "01234569"));
        jobs.add(new Job("designer", "Cong ty quang cao Totto",1100, "thiết kế quảng cáo", "HCM", "abcsoftware@gmail.com", "01234569"));
        jobs.add(new Job("content writer","Nha nam Book inc", 600, "viết nội dung quảng cáo sản phẩm", "HCM", "abcsoftware@gmail.com", "01234569"));
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
