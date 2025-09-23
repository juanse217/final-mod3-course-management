package com.sebastian.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sebastian.cursos.model.Course;
import com.sebastian.cursos.model.Registration;
import com.sebastian.cursos.model.Student;
import com.sebastian.cursos.repository.memory.MemoryCourseRepositoryImpl;
import com.sebastian.cursos.repository.memory.MemoryRegistrationRepositoryImpl;
import com.sebastian.cursos.service.ManagerService;
import com.sebastian.cursos.sharedExceptions.CourseNotFoundException;
import com.sebastian.cursos.sharedExceptions.RegistrationNotFoundException;

@ExtendWith(MockitoExtension.class)
public class ManagerServiceTest {
    //Dependencias de la clase a testear: 
    @Mock
    private MemoryRegistrationRepositoryImpl registrationRepo; 
    @Mock
    private MemoryCourseRepositoryImpl courseRepo;

    //Clase a testear
    @InjectMocks
    private ManagerService service; 

    Course course;
    Registration registration;
    Student st; 

    @BeforeEach
    void start(){
        course = new Course("01", "Fisica", 10);
        st = new Student("Juan", "juanse@gmail.com", "01");
        registration = new Registration(course, st);
    }

    @Test
    void addCourseTest(){
        service.addCourse(course);

        ArgumentCaptor<Course> courseArgumentCaptor = ArgumentCaptor.forClass(Course.class);

        verify(courseRepo).addCourse(any(Course.class));

        verify(courseRepo).addCourse(courseArgumentCaptor.capture());

        assertEquals("Fisica", courseArgumentCaptor.getValue().getName());
    }

    @Test
    void registerStudentTest(){
        service.registerStudent(st, course);

        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);

         ArgumentCaptor<Course> courseArgumentCaptor = ArgumentCaptor.forClass(Course.class);

         verify(registrationRepo).registerStudent(any(Student.class), any(Course.class));

         verify(registrationRepo).registerStudent(studentArgumentCaptor.capture(), courseArgumentCaptor.capture());

         assertEquals("Juan", studentArgumentCaptor.getValue().getName());

         assertEquals("01", courseArgumentCaptor.getValue().getCode());
    }

    @Test
    void getCourseByCodeTest() throws CourseNotFoundException{
        String id = "01";

        when(courseRepo.getCourseByCode(id)).thenReturn(course);
        
        Course actual = service.getCourseByCode(id);

        assertNotNull(actual);

        assertAll(() -> {
            assertEquals(id, actual.getCode());
            assertEquals("Fisica", actual.getName());
            assertEquals(10, actual.getMaxCapacity());
        });
    }

    @Test
    void getAllCoursesTest() throws CourseNotFoundException{
        List<Course> courses = List.of(course,  new Course("02", "Programacion", 5), new Course("03", "Mecanica", 3));

        when(courseRepo.getAllCourses()).thenReturn(courses);

        List<Course> actualCourses = service.getAllCourses();

        assertNotNull(actualCourses);

        assertAll(() -> {
            assertEquals(courses, actualCourses);
            assertEquals("02", actualCourses.get(1).getCode());
        });
    }

    @Test
    void getRegistrationsByStudentTest() throws RegistrationNotFoundException{
        List<Registration> registrations = List.of(registration);
        when(registrationRepo.getRegistrationsByStudent(st)).thenReturn(registrations);

        List<Registration> actualRegistration = service.getRegistrationsByStudent(st);

        assertAll(()->{
            assertEquals(registrations, actualRegistration);
        });
    }

    @Test
    void deleteCourseTest(){
        String id = "01";
        service.deleteCourse(id);

        verify(courseRepo).deleteCoursebyCode(any(String.class));
    }
}
