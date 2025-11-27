package com.madrasati.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private String username;
    private String token;
    private String email;
    private String role;
}
