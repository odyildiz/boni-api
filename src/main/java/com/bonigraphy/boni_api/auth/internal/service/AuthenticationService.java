package com.bonigraphy.boni_api.auth.internal.service;

import com.bonigraphy.boni_api.auth.internal.model.dto.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        password
                )
        );

        if (!authentication.isAuthenticated()) {
            throw new UsernameNotFoundException("User not found with given email or password");
        }

        var jwtToken = jwtService.generateToken(email);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
