package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    private final String secretKey = "jwt-secret-key";

    @RequestMapping("/authenticate")
    public Map<String, String> authenticate(HttpServletRequest request) {
        LOGGER.info("START authenticate()");
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new RuntimeException("Missing or invalid Authorization header.");
        }

        String base64Credentials = authHeader.substring("Basic ".length());
        String credentials = new String(Base64.getDecoder().decode(base64Credentials));
        String[] values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];

        if (!username.equals("user") || !password.equals("pwd")) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        LOGGER.info("END authenticate()");
        return response;
    }
}
