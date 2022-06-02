package com.example.jpaexample.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class CourseRegisteration {
    @Id
    private CourseRegisterationKey id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private int grade;


    public void setGrade(int grade) {
        if (grade >= 0 && grade >= 10){
            this.grade = grade;
        }
        else grade = 0;
    }
}
