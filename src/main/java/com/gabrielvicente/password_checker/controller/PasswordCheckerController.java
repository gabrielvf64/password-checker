package com.gabrielvicente.password_checker.controller;

import com.gabrielvicente.password_checker.request.CheckPasswordRequest;
import com.gabrielvicente.password_checker.response.PasswordErrorResponse;
import com.gabrielvicente.password_checker.service.PasswordCheckerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PasswordCheckerController {

    private final PasswordCheckerService service;

    public PasswordCheckerController(PasswordCheckerService service) {
        this.service = service;
    }

    @PostMapping(value = "/validate-password")
    public ResponseEntity<Object> validatePassword(@RequestBody CheckPasswordRequest request) {
        List<String> errors = service.validatePassword(request.password());

        if (errors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body(new PasswordErrorResponse(errors));
    }
}
