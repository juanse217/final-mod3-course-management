package com.sebastian.cursos.repository.memory;

import java.util.ArrayList;
import java.util.List;

import com.sebastian.cursos.model.Course;
import com.sebastian.cursos.repository.ICourseRepository;
import com.sebastian.cursos.sharedExceptions.CourseNotFoundException;

public class MemoryCourseRepositoryImpl implements ICourseRepository{
    private List<Course> courses;

    public MemoryCourseRepositoryImpl(){
        courses = new ArrayList<>();
    }
    @Override
    public Course getCourseByCode(String code) throws CourseNotFoundException{
 
        for (Course courseIteration : courses) {
            if(courseIteration.getCode().equals(code)){
                return courseIteration; 
            }
        }
        
        throw new CourseNotFoundException("The course with the code " + code + " was not found");
      
    }

    @Override
    public List<Course> getAllCourses() throws CourseNotFoundException{
        if(courses != null){
            return courses; 
        }
        
        throw new CourseNotFoundException("The courses array hasn't been intialized");
    }

    @Override
    public void addCourse(Course course) {
       courses.add(course);
    }

    @Override
    public void deleteCoursebyCode(String code) {
        courses = courses.stream().filter(x -> x.getCode() != code).toList();
    }

}
