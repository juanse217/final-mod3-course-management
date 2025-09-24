package com.sebastian.cursos.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    public ManagerService(){
        logger.info("Instanciacion ManagerService");
        regisRepo = new MemoryRegistrationRepositoryImpl();
        courseRepo = new MemoryCourseRepositoryImpl(); 
    }

    public void addCourse(Course course){
        logger.info("Añadiendo curso " + course.getName());
        courseRepo.addCourse(course);
    }

    public void registerStudent(Student student, Course course){
        logger.info("Registrando estudiante " + student.getName() + " en curso " + course.getName());
        regisRepo.registerStudent(student, course);
    }

    public Course getCourseByCode(String code)throws CourseNotFoundException{
        logger.info("Petición para retornar curso por el codigo " + code);
        return courseRepo.getCourseByCode(code);
    }

    public List<Course> getAllCourses() throws CourseNotFoundException{
        logger.info("Peticion para retornar todos los cursos");
        return courseRepo.getAllCourses(); 
    }

    public List<Registration> getRegistrationsByStudent(Student st) throws RegistrationNotFoundException{
        logger.info("Petición para retornar todos los registros de un estudiante " + st.getName());
        return regisRepo.getRegistrationsByStudent(st);
    }

    public void deleteCourse(String id){
        logger.info("Eliminacion de curso con id: " + id);
        courseRepo.deleteCoursebyCode(id);
    }


}
