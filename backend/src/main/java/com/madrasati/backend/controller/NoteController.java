package com.madrasati.backend.controller;

import com.madrasati.backend.model.Note;
import com.madrasati.backend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
class NoteController {
    @Autowired
    private NoteService service;

    @GetMapping
    public List<Note> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Note save(@RequestBody Note note) {
        return service.save(note);
    }

    @PutMapping("/{id}")
    public Note update(@PathVariable Long id, @RequestBody Note note) {
        note.setId(id);
        return service.save(note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}