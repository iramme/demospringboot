package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ControllerTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void cleanDatabase() {
        studentRepository.deleteAll();
    }

    @Test
    @Order(1)
    void shouldSaveStudent() {
        Student student = new Student();
        student.setName("Charlie");
        student.setAddress("Algeria");

        studentRepository.save(student);

        assertThat(studentRepository.count()).isEqualTo(1);
    }

    @Test
    @Order(2)
    void shouldFindAllStudents() {
        Student student = new Student();
        student.setName("Charlie");
        student.setAddress("Algeria");
        studentRepository.save(student);

        List<Student> students = studentRepository.findAll();
        assertThat(students).hasSize(1);
        assertThat(students.get(0).getName()).isEqualTo("Charlie");
    }
}
