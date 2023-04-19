package com.example.damiankocjan_ui;

import java.util.ArrayList;

public class State {
    private static State instance = null;
    private String email;
    private String password;
    private final ArrayList<String> tasks;

    private State() {
        email = "";
        password = "";
        tasks = new ArrayList<>();
    }

    public static State getInstance() {
        if (instance == null) {
            instance = new State();
        }
        return instance;
    }

    public void login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean isLogged() {
        return !email.isEmpty() && !password.isEmpty();
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }
}
