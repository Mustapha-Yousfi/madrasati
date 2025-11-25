package com.madrasati.backend.service;

import com.madrasati.backend.dto.RegisterRequest;
import com.madrasati.backend.dto.UserResponse;
import com.madrasati.backend.entity.Role;
import com.madrasati.backend.entity.User;
import com.madrasati.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();

    public UserResponse register(RegisterRequest registerRequest) {

        if (userRepository.findByUserName(registerRequest.getUserName()).isPresent()) {

            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .userName(registerRequest.getUserName())
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();

        User savedUser = userRepository.save(user);

        return UserResponse.builder()
                .id(savedUser.getId())
                .userName(savedUser.getUserName())
                .email(savedUser.getEmail())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .role(savedUser.getRole())
                .build();
    }
}
