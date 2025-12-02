package com.madrasati.backend.service;

import com.madrasati.backend.dto.CreateStudentRequest;
import com.madrasati.backend.dto.StudentListItem;
import com.madrasati.backend.dto.StudentResponse;
import com.madrasati.backend.entity.Classroom;
import com.madrasati.backend.entity.Student;
import com.madrasati.backend.exception.ClassroomNotFoundException;
import com.madrasati.backend.repository.ClassroomRepository;
import com.madrasati.backend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ClassroomRepository classroomRepository;

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        Classroom classroom = classroomRepository.findById(createStudentRequest.getClassroomId())
                .orElseThrow(()-> new ClassroomNotFoundException("Classroom not found"));

        Student student = Student.builder()
                .firstName(createStudentRequest.getFirstName())
                .lastName(createStudentRequest.getLastName())
                .classroom(classroom)
                .build();

        Student savedStudent = studentRepository.save(student);

        return mapToStudentResponse(savedStudent);
    }
    public List<StudentListItem> getAllStudents() {
        return studentRepository
                .findAll()
                .stream()
                .map(this::mapToStudentListItem).toList();
    }

    private StudentListItem mapToStudentListItem(Student savedStudent) {

        return StudentListItem.builder()
                .id(savedStudent.getId())
                .firstName(savedStudent.getFirstName())
                .lastName(savedStudent.getLastName())
                .classroomId(savedStudent.getClassroom().getId())
                .build();
    }
    private StudentResponse mapToStudentResponse(Student savedStudent) {

        return StudentResponse.builder()
                .id(savedStudent.getId())
                .firstName(savedStudent.getFirstName())
                .lastName(savedStudent.getLastName())
                .classroomId(savedStudent.getClassroom().getId())
                .build();
    }

}
