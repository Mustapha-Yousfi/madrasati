package com.madrasati.backend.service;

import com.madrasati.backend.model.Professor;
import com.madrasati.backend.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public Professor addProfessor(Professor professor) {
        return professorRepository.save(professor);
    }
    public Professor updateProfessor(Professor professor) {
        Professor entity = getProfessorById(professor.getId());
        if (entity != null)  {
            return professorRepository.save(professor);
        }
        return null;
    }
    public void deleteProfessor(long id) {
        professorRepository.deleteById(id);
    }
}
