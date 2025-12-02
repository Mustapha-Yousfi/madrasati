package com.madrasati.backend.controller;

import com.madrasati.backend.dto.CreateSchoolRequest;
import com.madrasati.backend.dto.SchoolResponse;
import com.madrasati.backend.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    public ResponseEntity<SchoolResponse> createSchool(@RequestBody CreateSchoolRequest createSchoolRequest) {

        SchoolResponse schoolResponse = schoolService.createSchool(createSchoolRequest);
        return ResponseEntity.ok().body(schoolResponse);

    }
}
