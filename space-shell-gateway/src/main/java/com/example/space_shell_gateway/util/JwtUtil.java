package com.example.space_shell_gateway.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // 🔐 Secret key used for signing and verifying JWT
    private final Key key = Keys.hmacShaKeyFor(
            "mysecretkeymysecretkeymysecretkey".getBytes()
    );

    // 🟢 Generate JWT after successful login
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // who the token belongs to
                .setIssuedAt(new Date()) // when token was created
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60)
                ) // token validity (1 hour)
                .signWith(key, SignatureAlgorithm.HS256) // sign token
                .compact();
    }

    // 🟢 Extract username from JWT
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // 🟢 Validate token against user details
    public boolean isTokenValid(String token, String username) {
        try {
            final String extractedUsername = extractUsername(token);
            return extractedUsername.equals(username) && !isTokenExpired(token);
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // 🔍 Check if token is expired
    private boolean isTokenExpired(String token) {
        return extractClaims(token)
                .getExpiration()
                .before(new Date());
    }

    // 🔍 Common method to parse claims safely
    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
