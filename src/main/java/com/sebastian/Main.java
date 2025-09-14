package com.sebastian;

import com.sebastian.cursos.model.Course;
import com.sebastian.cursos.model.Student;
import com.sebastian.cursos.service.ManagerService;

public class Main {
    public static void main(String[] args) {
        ManagerService service = new ManagerService(); 
        Student st = new Student("Seb", "peligroso@gmail.com", "s1");
        Student st1 = new Student("Seba", "peligroso2@gmail.com", "s2");
        Student st2 = new Student("Sebas", "peligroso3@gmail.com", "s3");

        Course course = new Course("c1", "Matematica", 3);
        service.addCourse(course);
        Course course1 = new Course("c2", "fisica", 1);
        service.addCourse(course1);
        Course course2 = new Course("c3", "Programacion", 10);
        service.addCourse(course2);

        service.registerStudent(st, course);
        service.registerStudent(st1, course);
        service.registerStudent(st2, course);

        service.registerStudent(st, course1);

        service.registerStudent(st, course2);
        service.registerStudent(st1, course2);
        service.registerStudent(st2, course2);

        try {
            System.out.println(service.getRegistrationsByStudent(st) + "\n\n");
            System.out.println(service.getRegistrationsByStudent(st1)+ "\n\n");
            System.out.println(service.getRegistrationsByStudent(st2)+ "\n\n");
            System.out.println(service.getAllCourses());
            System.out.println(service.getCourseByCode("c1"));
            service.deleteCourse("c1");
            System.out.println(service.getAllCourses());
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        System.out.println(course.getStudents());
        

        
       
    }
}