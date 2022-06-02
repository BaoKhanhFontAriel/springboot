package com.example.jpaexample;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.jpaexample.model.Course;
import com.example.jpaexample.model.CourseRegisteration;
import com.example.jpaexample.model.CourseRegisterationKey;
import com.example.jpaexample.model.Student;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class CourseTest {
    @Autowired
    private EntityManager tem;

    @Test
    public void CourseRegisterationTest() {
        Student student = new Student();
        tem.persist(student);

        Course course = new Course();
        tem.persist(course);

        CourseRegisteration grade = CourseRegisteration.builder().id(new CourseRegisterationKey())
                                                        .student(student)
                                                        .course(course)
                                                        .grade(10)
                                                        .build();
        tem.persist(grade);

        CourseRegisteration persitedCourseRating = tem.find(CourseRegisteration.class, new CourseRegisterationKey(1L, 1L));
        assertThat(persitedCourseRating).isNotNull();
        assertThat(persitedCourseRating.getStudent().getId()).isEqualTo(1L);
        assertThat(persitedCourseRating.getCourse().getId()).isEqualTo(1L);

    }
}
