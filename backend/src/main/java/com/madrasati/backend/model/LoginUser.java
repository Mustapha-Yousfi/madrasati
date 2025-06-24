package com.madrasati.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "login_user", schema = "public")
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(name = "schema_name", nullable = false, length = 50)
    private String schemaName;

    @Enumerated(EnumType.STRING)
    @Column(name = "global_role", nullable = false, length = 50)
    private GlobalRole globalRole;

    public enum GlobalRole {
        SUPER_ADMIN,
        TENANT_USER
    }


    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public GlobalRole getGlobalRole() {
        return globalRole;
    }

    public void setGlobalRole(GlobalRole globalRole) {
        this.globalRole = globalRole;
    }
}