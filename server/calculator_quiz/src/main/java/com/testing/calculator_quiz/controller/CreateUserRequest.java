package com.testing.calculator_quiz.controller;

public class CreateUserRequest {

    private String email;
    private String name;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String email, String name) {
        this.email = email;
        this.name = name;

    }

    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
}