package com.testing.calculator_quiz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity(name = "SCORE")
@Getter
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private int userId;
    private int score;
}
