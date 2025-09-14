package com.sebastian.cursos.service;

import java.util.List;

import com.sebastian.cursos.model.Course;
import com.sebastian.cursos.model.Registration;
import com.sebastian.cursos.model.Student;
import com.sebastian.cursos.repository.memory.MemoryCourseRepositoryImpl;
import com.sebastian.cursos.repository.memory.MemoryRegistrationRepositoryImpl;
import com.sebastian.cursos.sharedExceptions.CourseNotFoundException;
import com.sebastian.cursos.sharedExceptions.RegistrationNotFoundException;

public class ManagerService {
    private MemoryRegistrationRepositoryImpl regisRepo; 
    private MemoryCourseRepositoryImpl courseRepo; 

    //TODO: tests with JUnit and Mockito, and Logs. 

    public ManagerService(){
        regisRepo = new MemoryRegistrationRepositoryImpl();
        courseRepo = new MemoryCourseRepositoryImpl(); 
    }

    public void addCourse(Course course){
        courseRepo.addCourse(course);
    }

    public void registerStudent(Student student, Course course){
        regisRepo.registerStudent(student, course);
    }

    public Course getCourseByCode(String code)throws CourseNotFoundException{
        return courseRepo.getCourseByCode(code);
    }

    public List<Course> getAllCourses() throws CourseNotFoundException{
        return courseRepo.getAllCourses(); 
    }

    public List<Registration> getRegistrationsByStudent(Student st) throws RegistrationNotFoundException{
        return regisRepo.getRegistrationsByStudent(st);
    }

    public void deleteCourse(String id){
        courseRepo.deleteCoursebyCode(id);
    }


}
