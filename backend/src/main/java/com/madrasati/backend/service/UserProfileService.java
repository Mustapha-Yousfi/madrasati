package com.madrasati.backend.service;

import com.madrasati.backend.dto.CurrentUserResponse;
import com.madrasati.backend.dto.UpdateProfileRequest;
import com.madrasati.backend.entity.User;
import com.madrasati.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserRepository userRepository;


    public CurrentUserResponse getCurrentUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found : "+ username));

        return mapCurrentUserResponse(user);
    }

    public CurrentUserResponse updateCurrentUser(String username, UpdateProfileRequest request) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found : "+ username));

        if (request.getFirstName() != null) user.setFirstName(request.getFirstName());
        if (request.getLastName() != null) user.setLastName(request.getLastName());
        if (request.getEmail() != null)  user.setEmail(request.getEmail());
        userRepository.save(user);

        return mapCurrentUserResponse(user);
    }

    private CurrentUserResponse mapCurrentUserResponse(User user) {
        CurrentUserResponse dto = new CurrentUserResponse();
        dto.setUsername(user.getUsername());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());

        return dto;
    }
}
