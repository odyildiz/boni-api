package com.bonigraphy.boni_api.auth.internal.service;

import com.bonigraphy.boni_api.auth.internal.model.dto.AuthenticationResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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
    private final UserDetailService userDetailsService;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    public AuthenticationResponse authenticate(String email, String password, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        password
                )
        );

        if (!authentication.isAuthenticated()) {
            throw new UsernameNotFoundException("User not found with given email or password");
        }

        var accessToken = jwtService.generateToken(email);
        var refreshToken = jwtService.generateRefreshToken(email);

        Cookie refreshCookie = new Cookie("refreshToken", refreshToken);
        refreshCookie.setHttpOnly(true);
        refreshCookie.setSecure(!activeProfile.equals("dev"));
        refreshCookie.setPath("/panel/auth/refresh");
        refreshCookie.setAttribute("SameSite", activeProfile.equals("dev") ? "None" : "Strict");
        refreshCookie.setMaxAge((int) jwtService.getRefreshExpiration());

        response.addCookie(refreshCookie);

        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .build();
    }

    public AuthenticationResponse refreshToken(String refreshToken, HttpServletResponse response) {
        final String userEmail = jwtService.extractUsername(refreshToken);
        
        if (userEmail != null) {
            var user = this.userDetailsService.loadUserByUsername(userEmail);
            
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(userEmail);
                var newRefreshToken = jwtService.generateRefreshToken(userEmail);

                Cookie refreshCookie = new Cookie("refreshToken", newRefreshToken);
                refreshCookie.setHttpOnly(true);
                refreshCookie.setSecure(false);
                refreshCookie.setPath("/panel/auth/refresh");
                refreshCookie.setAttribute("SameSite", "Strict");
                refreshCookie.setMaxAge((int) jwtService.getRefreshExpiration());

                response.addCookie(refreshCookie);
                
                return AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .build();
            }
        }
        
        throw new RuntimeException("Invalid refresh token");
    }

}
