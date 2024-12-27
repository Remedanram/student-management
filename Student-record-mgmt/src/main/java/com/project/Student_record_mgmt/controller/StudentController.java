package com.project.Student_record_mgmt.controller;

import com.project.Student_record_mgmt.entity.Student;
import com.project.Student_record_mgmt.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {
     @Autowired
    private  StudentService service;

    // Register a new student
    @PostMapping
    public ResponseEntity<String> register(@RequestBody Student student) {
        service.register(student); // Register the student via the service layer
        return new ResponseEntity<>("Student Registered Successfully", HttpStatus.CREATED); // Return HTTP 201 status
    }

    // Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = service.getAll();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return HTTP 204 if no students are found
        }
        return new ResponseEntity<>(students, HttpStatus.OK); // Return HTTP 200 with the list of students
    }
}
