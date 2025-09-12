package com.sebastian.cursos.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name; 
    private String email;
    private String id; 
    private List<Course> courses;

    public Student(String name, String email, String id) {
        this.name = name;
        this.email = email;
        this.id = id;
        courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", email=" + email + ", id=" + id + "]";
    }

    
    
}
