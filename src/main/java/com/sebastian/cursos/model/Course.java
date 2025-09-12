package com.sebastian.cursos.model;

import java.util.ArrayList;
import java.util.List;


public class Course {
    private String code; 
    private String name; 
    private int maxCapacity; 
    private List<Student> students;

    public Course(String code, String name, int maxCapacity) {
        this.code = code;
        this.name = name;
        this.maxCapacity = maxCapacity;
        students = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }
    public List<Student> getStudents() {
        return students;
    }

    public boolean isFull(){
        return students.size() >= maxCapacity;
    }

    public void addStudent(Student student){
        if(isFull()){
            throw new FullCourseException("El curso " + name + " está lleno");
        }
        students.add(student);
    }

    @Override
    public String toString() {
        return "Course [code=" + code + ", name=" + name + ", maxCapacity=" + maxCapacity;
    }

    
}
