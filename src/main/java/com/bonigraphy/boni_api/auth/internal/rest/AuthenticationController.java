package com.bonigraphy.boni_api.auth.internal.rest;

import com.bonigraphy.boni_api.auth.internal.model.dto.AuthenticationRequest;
import com.bonigraphy.boni_api.auth.internal.model.dto.AuthenticationResponse;
import com.bonigraphy.boni_api.auth.internal.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/panel/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request.getEmail(), request.getPassword()));
    }

}