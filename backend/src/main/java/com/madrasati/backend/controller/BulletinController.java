package com.madrasati.backend.controller;

import com.madrasati.backend.model.Bulletin;
import com.madrasati.backend.service.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bulletins")
class BulletinController {
    @Autowired
    private BulletinService service;

    @GetMapping
    public List<Bulletin> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Bulletin save(@RequestBody Bulletin bulletin) {
        return service.save(bulletin);
    }

    @PutMapping("/{id}")
    public Bulletin update(@PathVariable Long id, @RequestBody Bulletin bulletin) {
        bulletin.setId(id);
        return service.save(bulletin);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
