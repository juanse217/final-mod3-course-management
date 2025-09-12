package com.sebastian.cursos.model;

import java.time.LocalDate;

public class Registration {
    private LocalDate registrationDate; 
    private Course course; 
    private Student student;

    public Registration(Course course, Student student) {
        this.course = course;
        this.student = student;
        registrationDate = LocalDate.now();
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Registration [registrationDate=" + registrationDate + ", course=" + course + ", student=" + student
                + "]";
    }

    

    
}
