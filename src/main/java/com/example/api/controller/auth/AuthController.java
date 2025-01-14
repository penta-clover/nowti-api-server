package com.example.api.controller;

import com.example.api.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username) {
        log.debug("login request of {}", username);
        String token = authService.login(username);
        return ResponseEntity.ok("Bearer " + token);
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestParam("Authorization") String authorizationHeader) {
        String token = authorizationHeader.replace("Bearer ", "");
        boolean isValid = authService.validateToken(token);
        return ResponseEntity.ok(isValid ? "Token is valid" : "Invalid token");
    }
}
