package com.madrasati.backend.controller;

import com.madrasati.backend.dto.ClassroomResponse;
import com.madrasati.backend.dto.CreateClassRequest;
import com.madrasati.backend.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(("/api/classes"))
public class ClassroomController {

    private final ClassroomService classroomService;

    @PostMapping
    public ResponseEntity<ClassroomResponse> createClassRoom(@RequestBody CreateClassRequest createClassRequest) {
        ClassroomResponse classRoomResponse= classroomService.createClassRoom(createClassRequest);
        return ResponseEntity.ok().body(classRoomResponse);
    }
}
