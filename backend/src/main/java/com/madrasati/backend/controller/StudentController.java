package com.madrasati.backend.controller;

import com.madrasati.backend.dto.CreateStudentRequest;
import com.madrasati.backend.dto.StudentListItem;
import com.madrasati.backend.dto.StudentResponse;
import com.madrasati.backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
        return ResponseEntity.ok(studentService.createStudent(createStudentRequest));
    }

    @GetMapping
    public ResponseEntity<List<StudentListItem>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
