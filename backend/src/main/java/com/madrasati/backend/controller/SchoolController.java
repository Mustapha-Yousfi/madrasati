package com.madrasati.backend.controller;

import com.madrasati.backend.dto.CreateSchoolRequest;
import com.madrasati.backend.dto.SchoolListItem;
import com.madrasati.backend.dto.SchoolResponse;
import com.madrasati.backend.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping
    public ResponseEntity<List<SchoolListItem>> getAllSchools() {
        return ResponseEntity.ok(schoolService.getAllSchools());
    }
    @PostMapping
    public ResponseEntity<SchoolResponse> createSchool(@RequestBody CreateSchoolRequest createSchoolRequest) {

        SchoolResponse schoolResponse = schoolService.createSchool(createSchoolRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(schoolResponse);

    }
}
