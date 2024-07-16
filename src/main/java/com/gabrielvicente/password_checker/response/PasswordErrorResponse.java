package com.gabrielvicente.password_checker.response;

import java.util.List;

public record PasswordErrorResponse(List<String> errors) {
}
