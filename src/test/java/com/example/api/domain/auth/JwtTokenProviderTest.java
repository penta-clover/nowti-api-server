package com.example.api.domain.auth;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtTokenProviderTest {
    private final JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
    @Test
    void validateToken() {
        // given
        String token = jwtTokenProvider.generateToken("test1234");

        // when
        boolean isValid = jwtTokenProvider.validateTokens(token);

        // then
        Assertions.assertThat(isValid);
    }
}