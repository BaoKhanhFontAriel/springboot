package vn.techmaster.grud_job_list.controller;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import vn.techmaster.grud_job_list.dto.JobRequest;
import vn.techmaster.grud_job_list.model.Job;
import vn.techmaster.grud_job_list.model.Location;

@RestController
@RequestMapping("/job")
public class JobController {
    private ConcurrentHashMap<String, Job> jobs;

    public JobController() {
        jobs = new ConcurrentHashMap<>();
        jobs.put("tm01", 
        new Job("tm01", "ke toan", "quan ly so sach", Location.HANOI, 5000000, 12000000, "phongtuyendung@techmaster.vn"));
        jobs.put("tm02", 
        new Job("tm02", "ke toan truong", "quan ly so sach", Location.HCM, 10000000, 20000000, "phongtuyendung@techmaster.vn"));
        jobs.put("tm03", 
        new Job("tm03", "giam doc tai chinh", "quan tri tai chinh", Location.DANANG, 100000000, 120000000, "phongtuyendung@techmaster.vn"));
        jobs.put("tm04", 
        new Job("tm04", "lap trinh vien", "lap trinh", Location.HAIPHONG, 1000000, 50000000, "phongtuyendung@techmaster.vn"));
        jobs.put("tm05", 
        new Job("tm05", "nhan vien nhan su", "quan ly nhan su", Location.DANANG, 5000000, 12000000, "phongtuyendung@techmaster.vn"));
    }

    @GetMapping
    public List<Job> getBooks() {
        return jobs.values().stream().toList();
    }

    @PostMapping()
    public Job createNewJob(@RequestBody JobRequest job){
        String uuid = UUID.randomUUID().toString();
        Job newJob = new Job(uuid, job.tittle(), job.description(), job.location(), job.min_salary(), job.max_salary(), job.email_to());
        jobs.put(uuid, newJob);
        return newJob;
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable("id") String id){
        Job existedJob = jobs.get(id);
        if (existedJob == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "job not existed");
        return existedJob;
    }

    @PutMapping("/{id}")
    public Job updateJobById(@PathVariable("id") String id, @RequestBody Job job){
        Job existedJob = getJobById(id);

        if (existedJob == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "job not existed");

        existedJob.setDescription(job.getDescription());
        existedJob.setEmail_to(job.getEmail_to());
        existedJob.setMax_salary(job.getMax_salary());
        existedJob.setMin_salary(job.getMin_salary());
        existedJob.setLocation(job.getLocation());
        return existedJob;
    }

    @DeleteMapping("/{id}")
    public Job deleteBookById(@PathVariable("id") String id){
        Job deletedJob = jobs.remove(id);
        return deletedJob;
    }

    @GetMapping("/sortbylocation")
    public List<Job> sortJobs() {
        return jobs.values().stream()
                .sorted((job0, job1) -> {
                    return job0.getLocation().getValue().charAt(0)
                            - job1.getLocation().getValue().charAt(0);
                }).toList();
    }


    @GetMapping("salary/{salary}")
    public List<Job> filterSalary(@PathVariable("salary") int salary){
        return jobs.values().stream().filter((job) -> (job.getMin_salary() <= salary && job.getMax_salary() >= salary)).toList();
    }

    @GetMapping("/keyword/{keyword}")
    public List<Job> filterKeyword(@PathVariable("keyword") String keyword){
        String[] words =  keyword.split("_");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            sb.append(" ");
        }

        String foundKey = sb.toString().trim();
        return jobs.values().stream()
        .filter((job) -> (job.getDescription().contains(foundKey) || job.getTittle().contains(foundKey))).toList();
    }

    @GetMapping("/query")
    public List<Job> query(@RequestParam("location") String l, @RequestParam("keyword") String k){
        Location where = Location.DANANG;
        switch(l){
            case "hanoi": where = Location.HANOI; break;
            case "danang": where = Location.DANANG; break;
            case "hcm": where = Location.HCM; break;
            case "haiphong": where = Location.HAIPHONG;
        }
        final Location location = where;
    
        List<Job> jobsByKeyword = filterKeyword(k);
        return jobsByKeyword.stream()
        .filter((job) -> job.getLocation().equals(location)).toList();
    }
    
}
