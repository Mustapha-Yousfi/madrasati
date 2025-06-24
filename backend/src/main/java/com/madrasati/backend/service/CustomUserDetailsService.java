package com.madrasati.backend.service;

import com.madrasati.backend.model.LoginUser;
import com.madrasati.backend.repository.LoginUserRepository;
import com.madrasati.backend.security.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final LoginUserRepository repository;

    public CustomUserDetailsService(LoginUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUser user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
        return new CustomUserDetails(user);
    }
}
