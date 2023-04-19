package com.example.damiankocjan_ui;

public class TaskValidator {

    public static boolean validate(String task) {
        return task.trim().length() > 0;
    }
}
