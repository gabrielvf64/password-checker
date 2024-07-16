package com.gabrielvicente.password_checker.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordCheckerService {

    public List<String> validatePassword(String password) {
        List<String> errors = new ArrayList<>();

        validateLength(password, errors);
        return errors;
    }

    private void validateLength(String password, List<String> errors) {
        if (password != null && password.length() < 8) {
            errors.add("Password must be at least 8 characters long");
        }
    }
}
