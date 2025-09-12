package com.sebastian.cursos.repository;

import java.util.List;

import com.sebastian.cursos.model.Course;
import com.sebastian.cursos.model.Registration;
import com.sebastian.cursos.model.Student;
import com.sebastian.cursos.sharedExceptions.RegistrationNotFoundException;

public interface IRegistrationRepository {
    List<Registration> getRegistrationsByStudent(Student student) throws RegistrationNotFoundException;
    void registerStudent(Student st, Course course);
}
