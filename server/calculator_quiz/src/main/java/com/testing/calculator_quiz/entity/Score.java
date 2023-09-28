package com.testing.calculator_quiz.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "SCORE")
@Table(name = "SCORE")
@Getter
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private int userId;
    private int score;
    @Column(name = "SCORE_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scoreDateTime;
}