
package com.example.demo.controller;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000") // ✅ important pour autoriser React à accéder à l’API
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Student add(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return true;
    }
@PutMapping("/update")
public Student update(@RequestBody Student student) {
return studentService.updateStudent(student);
}
}
