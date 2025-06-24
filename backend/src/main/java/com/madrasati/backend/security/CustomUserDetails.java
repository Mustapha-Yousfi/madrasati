package com.madrasati.backend.security;

import com.madrasati.backend.model.LoginUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final LoginUser loginUser;

    public CustomUserDetails(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

    public String getSchemaName() {
        return loginUser.getSchemaName();
    }

    @Override
    public String getUsername() {
        return loginUser.getUsername();
    }

    @Override
    public String getPassword() {
        return loginUser.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // pas de rôles pour l'instant
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
