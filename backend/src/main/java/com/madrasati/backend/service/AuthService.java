package com.madrasati.backend.service;

import com.madrasati.backend.dto.AuthenticationRequest;
import com.madrasati.backend.dto.AuthenticationResponse;
import com.madrasati.backend.entity.User;
import com.madrasati.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthenticationResponse login(AuthenticationRequest request) {

        User user = userRepository.findByUserName(request.getUserName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(
                user.getUserName(),
                Map.of("role", user.getRole().name())
        );

        return AuthenticationResponse.builder()
                .token(token)
                .userName(user.getUserName())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }
}
