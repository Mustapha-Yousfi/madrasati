package com.madrasati.backend.multitenant;

import com.madrasati.backend.security.CustomUserDetails;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SchemaTenantIdentifierResolver implements CurrentTenantIdentifierResolver <String>{
    @Override
    public String resolveCurrentTenantIdentifier() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof CustomUserDetails u) {
            return u.getSchemaName();
        }
        return "public";
    }
    @Override public boolean validateExistingCurrentSessions() { return true; }
}
