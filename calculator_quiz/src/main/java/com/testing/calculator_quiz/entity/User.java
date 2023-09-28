package com.testing.calculator_quiz.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity(name = "USERS")
@Table(name = "USERS")
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private int userId;
    private String email;
}

