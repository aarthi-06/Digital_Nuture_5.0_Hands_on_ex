package com.cognizant.jwt_handson.controller;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@RestController
public class AuthenticationController {

    private static final String SECRET =
            "this-is-a-demo-secret-key-for-jwt-hs256-signing";

    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {

        String username = getUsername(authHeader);
        String token = generateJwt(username);

        return Map.of("token", token);
    }

    private String getUsername(String authHeader) {

        String encodedCredentials = authHeader.substring("Basic ".length());

        byte[] decodedBytes =
                Base64.getDecoder().decode(encodedCredentials);

        String credentials =
                new String(decodedBytes, StandardCharsets.UTF_8);

        return credentials.substring(0, credentials.indexOf(':'));
    }

    private String generateJwt(String username) {

        Instant now = Instant.now();

        return Jwts.builder()
                .subject(username)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plusSeconds(20 * 60)))
                .signWith(key)
                .compact();
    }
}