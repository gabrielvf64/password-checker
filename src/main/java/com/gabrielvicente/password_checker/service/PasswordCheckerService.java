package com.gabrielvicente.password_checker.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordCheckerService {

    public List<String> validatePassword(String password) {
        List<String> errors = new ArrayList<>();

        hasAtLeastEightCharactersLong(password, errors);
        hasAtLeastOneCapitalLetter(password, errors);
        hasAtLeastOneLowerCaseLetter(password, errors);

        return errors;
    }

    private void hasAtLeastEightCharactersLong(String password, List<String> errors) {
        if (password != null && password.length() < 8) {
            errors.add("Password must be at least 8 characters long");
        }
    }

    private void hasAtLeastOneCapitalLetter(String password, List<String> errors) {
        if (password != null && !password.matches(".*[A-Z].*")) {
            errors.add("Password must contain at least one capital letter");
        }
    }

    private void hasAtLeastOneLowerCaseLetter(String password, List<String> errors) {
        if (password != null && !password.matches(".*[a-z].*")) {
            errors.add("Password must contain at least one lower case letter");
        }
    }
}
