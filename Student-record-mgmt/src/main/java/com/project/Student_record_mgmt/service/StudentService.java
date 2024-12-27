package com.project.Student_record_mgmt.service;

import com.project.Student_record_mgmt.entity.Student;
import com.project.Student_record_mgmt.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
     @Autowired
    private  StudentRepository repository;

    // Register a new student
    public void register(Student student) {

        Student student1 = new Student();
        student1.setName(student.getName());
        student1.setAddress(student.getAddress());

        repository.save(student); // Save the student to the database
    }

    // Get all students
    public List<Student> getAll() {
        return repository.findAll(); // This will return a List<Student> from the database
    }
}
