package com.madrasati.backend.service;

import com.madrasati.backend.dto.CreateSchoolRequest;
import com.madrasati.backend.dto.SchoolListItem;
import com.madrasati.backend.dto.SchoolResponse;
import com.madrasati.backend.entity.School;
import com.madrasati.backend.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return mapToSchoolResponse(savedSchool);
    }


    public List<SchoolListItem> getAllSchools() {
        return schoolRepository.findAll().stream().map(this::mapToSchoolListItem).toList();
    }

    private SchoolResponse mapToSchoolResponse(School school) {
        return SchoolResponse
                .builder()
                .id(school.getId())
                .name(school.getName())
                .description(school.getDescription())
                .address(school.getAddress())
                .build();

    }

    private SchoolListItem mapToSchoolListItem(School school) {
        return SchoolListItem
                .builder()
                .id(school.getId())
                .name(school.getName())
                .description(school.getDescription())
                .address(school.getAddress())
                .build();

    }

}
