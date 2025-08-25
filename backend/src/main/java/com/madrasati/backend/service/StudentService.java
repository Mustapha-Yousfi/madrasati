package com.madrasati.backend.service;

import com.madrasati.backend.model.Student;
import com.madrasati.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Optional<Student> findById(Long eleveId) {
        return repository.findById(eleveId);
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}