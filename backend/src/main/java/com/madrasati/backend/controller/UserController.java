package com.madrasati.backend.controller;

import com.madrasati.backend.dto.CurrentUserResponse;
import com.madrasati.backend.dto.UpdateProfileRequest;
import com.madrasati.backend.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserProfileService userProfileService;

    @GetMapping("/me")
    public ResponseEntity<CurrentUserResponse> getCurrentUser(Authentication authentication) {
        String username = authentication.getName();
        CurrentUserResponse currentUserResponse = userProfileService.getCurrentUser(username);
        return ResponseEntity.ok(currentUserResponse);
    }


    @PatchMapping("/me")
    public ResponseEntity<CurrentUserResponse> updateCurrentUser(@RequestBody UpdateProfileRequest updateProfileRequest,
                                                                 Authentication authentication) {
        String username = authentication.getName();
        CurrentUserResponse response = userProfileService.updateCurrentUser(username, updateProfileRequest);

        return ResponseEntity.ok(response);

    }
}
