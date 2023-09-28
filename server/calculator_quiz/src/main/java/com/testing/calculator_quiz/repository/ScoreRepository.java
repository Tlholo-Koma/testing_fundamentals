package com.testing.calculator_quiz.repository;

import com.testing.calculator_quiz.entity.Score;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ScoreRepository extends CrudRepository<Score, Integer> {
    @Query("SELECT t FROM SCORE t WHERE t.userId = :userId")
    Score getScore(int userId);


//    @Modifying
//    @Query("INSERT INTO SCORE (userId, score, scoreDateTime) VALUES (:userId, :score, CURRENT_TIMESTAMP)")
//    void setScore(@Param("userId") int userId, @Param("score") int score);




}