package com.madrasati.backend.controller;

import com.madrasati.backend.dto.AssignStudentRequest;
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

    @PatchMapping("/{id}/assign")
    public ResponseEntity<StudentResponse> assignStudentToClass(@PathVariable Long id, @RequestBody AssignStudentRequest assignStudentRequest) {
        return ResponseEntity.ok(studentService.assignStudentToClass(id,  assignStudentRequest));
    }

    @GetMapping
    public ResponseEntity<List<StudentListItem>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}
