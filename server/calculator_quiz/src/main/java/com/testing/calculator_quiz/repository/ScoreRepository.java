package com.testing.calculator_quiz.repository;

import com.testing.calculator_quiz.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Integer> {
    @Query("SELECT t FROM SCORE t WHERE t.userId = :userId")
    List<Score> getScore(int userId);

    @Modifying
    @Query("INSERT INTO SCORE (userId, score, scoreDateTime) VALUES (:userId, :score, :scoreDateTime)")
    void setScore(@Param("userId") int userId, @Param("score") int score, @Param("scoreDateTime") Date scoreDateTime);

//    @Modifying
//    @Query("INSERT INTO SCORE (email, score, scoreDateTime) VALUES (:email, :score, :scoreDateTime)")
//    void setScoreByEmail(@Param("email") String email, @Param("score") int score, @Param("scoreDateTime") Date scoreDateTime);
}
