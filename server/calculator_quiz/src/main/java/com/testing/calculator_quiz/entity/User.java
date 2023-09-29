package com.testing.calculator_quiz.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity(name = "USERS")
@Table(name = "USERS")
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String email;
    private String name;
}
