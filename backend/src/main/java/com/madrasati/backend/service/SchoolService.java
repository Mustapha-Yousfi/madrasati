package com.madrasati.backend.service;

import com.madrasati.backend.dto.CreateSchoolRequest;
import com.madrasati.backend.dto.SchoolResponse;
import com.madrasati.backend.entity.School;
import com.madrasati.backend.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;


    public SchoolResponse createSchool(CreateSchoolRequest createSchoolRequest) {
        School school = School.builder()
                .name(createSchoolRequest.getName())
                .description(createSchoolRequest.getDescription())
                .address(createSchoolRequest.getAddress())
                .build();

        School savedSchool = schoolRepository.save(school);

        return SchoolResponse
                .builder()
                .id(savedSchool.getId())
                .name(savedSchool.getName())
                .description(savedSchool.getDescription())
                .address(savedSchool.getAddress())
                .build();
    }


}
