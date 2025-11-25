package com.madrasati.backend.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String userName, Map<String, Object> extraClaims) {
        return Jwts.builder()
                .setSubject(userName)
                .addClaims(extraClaims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)) // 1 jour
                .signWith(key)
                .compact();
    }

    public String extractUserName(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
