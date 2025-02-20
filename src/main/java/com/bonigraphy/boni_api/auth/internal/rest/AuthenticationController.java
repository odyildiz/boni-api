package com.bonigraphy.boni_api.auth.internal.rest;

import com.bonigraphy.boni_api.auth.internal.model.dto.AuthenticationRequest;
import com.bonigraphy.boni_api.auth.internal.model.dto.AuthenticationResponse;
import com.bonigraphy.boni_api.auth.internal.service.AuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/panel/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(authenticationService.authenticate(request.getEmail(), request.getPassword(), response));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthenticationResponse> refreshToken(@CookieValue(value = "refreshToken") String refreshToken, HttpServletResponse response) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken, response));
    }

}