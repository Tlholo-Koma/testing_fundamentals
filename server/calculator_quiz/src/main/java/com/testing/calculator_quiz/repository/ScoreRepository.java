package com.testing.calculator_quiz.repository;

import com.testing.calculator_quiz.entity.Score;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<Score, Integer> {
    @Query("SELECT t FROM SCORE t WHERE t.userId = :userId")
    Score getScore(int userId);
}
