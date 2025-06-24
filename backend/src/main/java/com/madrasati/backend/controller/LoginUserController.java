package com.madrasati.backend.controller;

import com.madrasati.backend.model.LoginUser;
import com.madrasati.backend.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/login-users")
class LoginUserController {
    @Autowired
    private LoginUserService service;

    @GetMapping
    public List<LoginUser> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<LoginUser> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public LoginUser save(@RequestBody LoginUser user) {
        return service.save(user);
    }

    @PutMapping("/{id}")
    public LoginUser update(@PathVariable Long id, @RequestBody LoginUser user) {
        user.setId(id);
        return service.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
