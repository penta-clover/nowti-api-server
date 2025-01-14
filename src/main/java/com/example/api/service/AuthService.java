package com.example.api.service;

import com.example.api.domain.auth.JwtTokenProvider;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JwtTokenProvider jwtTokenProvider;

    public AuthService(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public String login(String username) {
        // 검증 로직 필요
        return jwtTokenProvider.generateToken(username);
    }

    public boolean validateToken(String token) {
        return jwtTokenProvider.validateTokens(token);
    }

    public String getUsernameFromToken(String token) {
        return jwtTokenProvider.getUsernameFromToken(token);
    }
}