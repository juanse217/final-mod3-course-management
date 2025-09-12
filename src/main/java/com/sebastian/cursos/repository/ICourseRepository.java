package com.sebastian.cursos.repository;

import java.util.List;

import com.sebastian.cursos.model.Course;
import com.sebastian.cursos.sharedExceptions.CourseNotFoundException;

public interface ICourseRepository {
    Course getCourseByCode(String code) throws CourseNotFoundException; 
    List<Course> getAllCourses()throws CourseNotFoundException;
    public void addCourse(Course course);
    void deleteCoursebyCode(String code) throws CourseNotFoundException; 
}
