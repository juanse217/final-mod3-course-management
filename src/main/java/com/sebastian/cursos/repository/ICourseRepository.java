package com.sebastian.cursos.repository;

import java.util.List;

import com.sebastian.cursos.model.Course;
import com.sebastian.cursos.sharedExceptions.CourseNotFoundException;

public interface ICourseRepository {
    Course getCourseByCode(String code) throws CourseNotFoundException; 
    List<Course> getAllCourses()throws CourseNotFoundException;
    void addCourse(Course course);
    void deletCoursebyCode(String code) throws CourseNotFoundException; 
}
