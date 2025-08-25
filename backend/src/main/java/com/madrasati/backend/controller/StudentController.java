package com.madrasati.backend.controller;

import com.madrasati.backend.model.Student;
import com.madrasati.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getAllStudents() {
        return service.findAll();
    }

    @PostMapping("/student")
    public Student setStudent(@RequestBody Student student) {
        return service.save(student);
    }

    @GetMapping(path = "student/{id}")
    public Student getStudent(@PathVariable("id") Long studentId) {
        return service.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("Eleve with id " + studentId + " not found"));
    }

    @PutMapping("/student/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return service.save(student);
    }

    @DeleteMapping("/student/{id}")
    public void delelteStudent(@PathVariable Long id) {
        service.delete(id);
    }

    // Moved to ControllerExceptionHandler to be shared by all controllers
//    @ExceptionHandler(NoSuchElementException.class)
//    public ErrorResponse notFound(NoSuchElementException ex) {
//        return ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.getMessage());
//    }
}
