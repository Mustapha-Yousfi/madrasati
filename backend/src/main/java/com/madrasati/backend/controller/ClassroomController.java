package com.madrasati.backend.controller;

import com.madrasati.backend.dto.ClassroomListItem;
import com.madrasati.backend.dto.ClassroomResponse;
import com.madrasati.backend.dto.CreateClassRequest;
import com.madrasati.backend.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(("/api/classes"))
public class ClassroomController {

    private final ClassroomService classroomService;

    @GetMapping
    public ResponseEntity<List<ClassroomListItem>> getAllClassrooms() {
        return ResponseEntity.ok(classroomService.getAllClassrooms());
    }

    @PostMapping
    public ResponseEntity<ClassroomResponse> createClassroom(@RequestBody CreateClassRequest createClassRequest) {
        ClassroomResponse classRoomResponse= classroomService.createClassroom(createClassRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(classRoomResponse);
    }
}
