package com.madrasati.backend.repository;

import com.madrasati.backend.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {

    Optional<LoginUser> findByUsername(String username);
}
