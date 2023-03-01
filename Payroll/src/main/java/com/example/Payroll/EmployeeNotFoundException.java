package com.example.Payroll;

public class EmployeeNotFoundException extends RuntimeException {
    EmployeeNotFoundException(int id) {
        super("Could not find employee " + id);
    }
}
