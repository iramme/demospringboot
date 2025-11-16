package com.example.demo.service;


import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Student student) {
return studentRepository.save(student);
}
}
