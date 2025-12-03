package com.madrasati.backend.service;

import com.madrasati.backend.dto.AssignTeacherRequest;
import com.madrasati.backend.dto.CreateTeacherRequest;
import com.madrasati.backend.dto.TeacherListItem;
import com.madrasati.backend.dto.TeacherResponse;
import com.madrasati.backend.entity.Classroom;
import com.madrasati.backend.entity.Teacher;
import com.madrasati.backend.exception.ClassroomNotFoundException;
import com.madrasati.backend.exception.TeacherNotFoundException;
import com.madrasati.backend.repository.ClassroomRepository;
import com.madrasati.backend.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    public final TeacherRepository teacherRepository;
    public final ClassroomRepository classroomRepository;


    public TeacherResponse createTeacher(CreateTeacherRequest createTeacherRequest) {
        Classroom classroom = classroomRepository.findById(createTeacherRequest.getClassroomId())
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found"));
        Teacher teacher = Teacher.builder()
                .firstName(createTeacherRequest.getFirstName())
                .lastName(createTeacherRequest.getLastName())
                .classroom(classroom)
                .build();
        Teacher savedTeacher = teacherRepository.save(teacher);
        return toTeacherResponse(savedTeacher);

    }

    public List<TeacherListItem> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(this::toTeacherListItem).toList();
    }

    public TeacherResponse assignTeacherToClass(Long id, AssignTeacherRequest assignTeacherRequest) {
        Teacher teacher =  teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException("Teacher not found"));
        Classroom classroom = classroomRepository.findById(assignTeacherRequest.getClassroomId())
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found"));

        teacher.setClassroom(classroom);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return toTeacherResponse(savedTeacher);
    }


    private TeacherResponse toTeacherResponse(Teacher teacher) {
        return TeacherResponse.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .classroomId(teacher.getClassroom().getId())
                .build();
    }
    private TeacherListItem toTeacherListItem(Teacher teacher) {
        return TeacherListItem.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .classroomId(teacher.getClassroom().getId())
                .build();
    }

}
