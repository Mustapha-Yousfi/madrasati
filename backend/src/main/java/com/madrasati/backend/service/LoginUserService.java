package com.madrasati.backend.service;

import com.madrasati.backend.model.LoginUser;
import com.madrasati.backend.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginUserService {
    @Autowired
    private LoginUserRepository repository;

    public List<LoginUser> findAll() {
        return repository.findAll();
    }

    public Optional<LoginUser> findById(Long id) {
        return repository.findById(id);
    }

    public LoginUser save(LoginUser user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
