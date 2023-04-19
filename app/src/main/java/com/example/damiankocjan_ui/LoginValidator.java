package com.example.damiankocjan_ui;

public class LoginValidator {

    public static boolean isEmailValid(String email) {
        String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(EMAIL_PATTERN) && email.trim().length() > 0;
    }

    public static boolean validate(String email, String password) {
        return isEmailValid(email) && password.trim().length() > 0;
    }
}
