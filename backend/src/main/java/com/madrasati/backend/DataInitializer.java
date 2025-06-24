package com.madrasati.backend;

import com.madrasati.backend.model.LoginUser;
import com.madrasati.backend.repository.LoginUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner init(LoginUserRepository repository) {
        return args -> {
            if (repository.findByUsername("anas.yousfi").isEmpty()) {
                LoginUser user = new LoginUser();
                user.setUsername("anas.yousfi");
                user.setPassword(BCrypt.hashpw("Password421", BCrypt.gensalt())); // mot de passe chiffré
                user.setSchemaName("alkindi"); // le schéma de cet utilisateur

                repository.save(user);
                System.out.println("Utilisateur de test inséré.");
            } else {
                System.out.println("Utilisateur déjà existant.");
            }
        };
    }
}
