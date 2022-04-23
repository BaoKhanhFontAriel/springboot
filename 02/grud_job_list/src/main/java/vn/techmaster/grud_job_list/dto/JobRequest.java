package vn.techmaster.dto;

import vn.techmaster.grud_job_list.model.Location;

public record JobRequest(String tittle,
        String description,
        Location location,
        int min_salary,
        int max_salary,
        String email_to) {
}
