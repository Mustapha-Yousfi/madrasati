package com.madrasati.backend.service;


import com.madrasati.backend.dto.ClassroomResponse;
import com.madrasati.backend.dto.CreateClassRequest;
import com.madrasati.backend.entity.Classroom;
import com.madrasati.backend.entity.School;
import com.madrasati.backend.exception.SchoolNotFoundException;
import com.madrasati.backend.repository.ClassroomRepository;
import com.madrasati.backend.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassroomService {
    private final ClassroomRepository classroomRepository;
    private final SchoolRepository schoolRepository;

    public ClassroomResponse createClassRoom(CreateClassRequest createClassRequest) {

        School school = schoolRepository.findById(createClassRequest.getSchoolId())
                .orElseThrow(() -> new SchoolNotFoundException("School not found"));

        Classroom classRoom = Classroom.builder()
                .name(createClassRequest.getName())
                .level(createClassRequest.getLevel())
                .school(school)
                .build();
        Classroom savedClassRoom = classroomRepository.save(classRoom);

        return ClassroomResponse.builder()
                .id(savedClassRoom.getId())
                .name(savedClassRoom.getName())
                .level(savedClassRoom.getLevel())
                .schoolId(savedClassRoom.getSchool().getId())
                .build();

    }
}
