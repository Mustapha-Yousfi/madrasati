package com.madrasati.backend.service;


import com.madrasati.backend.dto.ClassroomListItem;
import com.madrasati.backend.dto.ClassroomResponse;
import com.madrasati.backend.dto.CreateClassRequest;
import com.madrasati.backend.entity.Classroom;
import com.madrasati.backend.entity.School;
import com.madrasati.backend.exception.SchoolNotFoundException;
import com.madrasati.backend.repository.ClassroomRepository;
import com.madrasati.backend.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomService {
    private final ClassroomRepository classroomRepository;
    private final SchoolRepository schoolRepository;

    public ClassroomResponse createClassroom(CreateClassRequest createClassRequest) {

        School school = schoolRepository.findById(createClassRequest.getSchoolId())
                .orElseThrow(() -> new SchoolNotFoundException("School not found"));

        Classroom classRoom = Classroom.builder()
                .name(createClassRequest.getName())
                .level(createClassRequest.getLevel())
                .school(school)
                .build();
        Classroom savedClassRoom = classroomRepository.save(classRoom);

        return mapToClassroomResponse(savedClassRoom);

    }

    public List<ClassroomListItem> getAllClassrooms() {
        return classroomRepository.findAll().stream().map(this::mapToClassroomListItem).toList();
    }

    private ClassroomResponse mapToClassroomResponse(Classroom classroom) {
        return ClassroomResponse.builder()
                .id(classroom.getId())
                .name(classroom.getName())
                .level(classroom.getLevel())
                .schoolId(classroom.getSchool().getId())
                .build();
    }
    private ClassroomListItem mapToClassroomListItem(Classroom classroom) {
        return ClassroomListItem.builder()
                .id(classroom.getId())
                .name(classroom.getName())
                .level(classroom.getLevel())
                .schoolId(classroom.getSchool().getId())
                .build();
    }
}
