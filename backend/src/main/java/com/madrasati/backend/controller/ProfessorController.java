package com.madrasati.backend.controller;

import com.madrasati.backend.model.Professor;
import com.madrasati.backend.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/professor/{id}")
    public Professor getProfessorById(@PathVariable("id") long id) {
        return professorService.getProfessorById(id);
    }

    @PutMapping("/professor/{id}")
    public Professor update(@PathVariable Long id, @RequestBody Professor professor) {
        professor.setId(id);
        return professorService.addProfessor(professor);
    }

    @PostMapping("/professor")
    public Professor addProfessor(@RequestBody Professor professor) {
        return professorService.addProfessor(professor);
    }
    @DeleteMapping("/professor/{id}")
    public void deleteProfessor(@PathVariable("id") long id) {
        professorService.deleteProfessor(id);
    }

}
