package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class) // Active l'ordre défini par @Order
class ControllerTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeAll
    static void setup(@Autowired StudentRepository studentRepository) {
        // Vider la table une seule fois avant tous les tests
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
        // Ici, l'étudiant "Charlie" ajouté dans le test précédent existe encore
        List<Student> students = studentRepository.findAll();

        assertThat(students).hasSize(1);
        assertThat(students.get(0).getName()).isEqualTo("Charlie");
    }
}
