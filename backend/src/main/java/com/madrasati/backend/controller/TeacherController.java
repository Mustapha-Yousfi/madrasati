package com.madrasati.backend.controller;

import com.madrasati.backend.dto.AssignTeacherRequest;
import com.madrasati.backend.dto.CreateTeacherRequest;
import com.madrasati.backend.dto.TeacherListItem;
import com.madrasati.backend.dto.TeacherResponse;
import com.madrasati.backend.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherResponse> createTeacher(@RequestBody CreateTeacherRequest createTeacherRequest) {
        return ResponseEntity.ok(teacherService.createTeacher(createTeacherRequest));
    }

    @GetMapping
    public ResponseEntity<List<TeacherListItem>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @PatchMapping("/{id}/assign")
    public ResponseEntity<TeacherResponse> assignTeacherToClass(@PathVariable Long id, @RequestBody AssignTeacherRequest assignTeacherRequest) {
        return ResponseEntity.ok(teacherService.assignTeacherToClass(id, assignTeacherRequest));
    }
}
