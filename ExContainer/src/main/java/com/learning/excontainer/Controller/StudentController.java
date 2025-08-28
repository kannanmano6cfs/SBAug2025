package com.learning.excontainer.Controller;

import com.learning.excontainer.Model.Student;
import com.learning.excontainer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String index() {
        return "Hello World!! I am running on container in Docker Desktop!!";
    }

    @GetMapping("/students")
    public Iterable<Student> students() {
        Iterable<Student> students = studentRepository.findAll();
        return students;
    }

    @PostMapping("/new")
    public ResponseEntity<String> newStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return new ResponseEntity<String>("Student details added successfully", HttpStatus.OK);
    }
}
