package com.bonigraphy.boni_api.auth.internal.service;

import com.bonigraphy.boni_api.employee.EmployeePort;
import com.bonigraphy.boni_api.employee.EmployeeResponse;
import com.bonigraphy.boni_api.auth.internal.model.EmployeeUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final EmployeePort employeePort;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<EmployeeResponse> employee = employeePort.findByEmail(email);

        return employee.map(EmployeeUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
    }
}