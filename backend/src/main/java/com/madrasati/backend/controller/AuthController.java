package com.madrasati.backend.controller;

import com.madrasati.backend.dto.AuthenticationRequest;
import com.madrasati.backend.dto.AuthenticationResponse;
import com.madrasati.backend.dto.RegisterRequest;
import com.madrasati.backend.dto.UserResponse;
import com.madrasati.backend.service.AuthService;
import com.madrasati.backend.service.CustomUserDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CustomUserDetailsService customUserDetailsService;
    private final AuthService authService;

    @PostMapping("/register")
    public UserResponse register(@Valid @RequestBody RegisterRequest registerRequest) {
        return customUserDetailsService.register(registerRequest);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {
        return authService.login(request);
    }
}
