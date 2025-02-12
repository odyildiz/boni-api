package com.bonigraphy.boni_api.employee.internal.service;

import com.bonigraphy.boni_api.employee.EmployeePort;
import com.bonigraphy.boni_api.employee.EmployeeResponse;
import com.bonigraphy.boni_api.employee.internal.entity.Employee;
import com.bonigraphy.boni_api.employee.internal.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeePort {

    private final EmployeeRepository employeeRepository;

    @Override
    public Optional<EmployeeResponse> findByEmail(String email) {
        Optional<Employee> employee = employeeRepository.findByEmail(email);
        return employee.map(e -> new EmployeeResponse(e.getId(), e.getEmail(), e.getPassword(), e.getFullName(), e.getRole()));
    }
}
