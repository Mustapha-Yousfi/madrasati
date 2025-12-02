package com.madrasati.backend.dto;

import com.madrasati.backend.entity.Role;
import lombok.Data;

@Data
public class CurrentUserResponse {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;

}
