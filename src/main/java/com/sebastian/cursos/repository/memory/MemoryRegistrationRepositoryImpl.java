package com.sebastian.cursos.repository.memory;

import java.util.ArrayList;
import java.util.List;

import com.sebastian.cursos.model.Course;
import com.sebastian.cursos.model.FullCourseException;
import com.sebastian.cursos.model.Registration;
import com.sebastian.cursos.model.Student;
import com.sebastian.cursos.repository.IRegistrationRepository;
import com.sebastian.cursos.sharedExceptions.RegistrationNotFoundException;

public class MemoryRegistrationRepositoryImpl implements IRegistrationRepository{
    private List<Registration> registrations;

    public MemoryRegistrationRepositoryImpl(){
        registrations = new ArrayList<>();
    }
    @Override
    public List<Registration> getRegistrationsByStudent(Student student) throws RegistrationNotFoundException {
        List<Registration> studentRegistration = new ArrayList<>();

        for (Registration registration : registrations) {
            if(registration.getStudent().equals(student)){
                studentRegistration.add(registration);
            }
        }

        if(!studentRegistration.isEmpty()){
            return studentRegistration;
        }else{
            throw new RegistrationNotFoundException("There are no registrations for the student " + student.getName()); 
        }
    }

    @Override
    public void registerStudent(Student st, Course course) {
        if(course.isFull()){
            throw new FullCourseException("The course is full");
        }
        course.addStudent(st);
        st.addCourse(course);
        registrations.add(new Registration(course, st));
    }

}
