package com.bonigraphy.boni_api.employee;

import java.util.Optional;

public interface EmployeePort {

    Optional<EmployeeResponse> findByEmail(String email);
}
