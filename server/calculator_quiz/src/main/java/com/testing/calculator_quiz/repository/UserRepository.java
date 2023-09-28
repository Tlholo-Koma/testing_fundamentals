package com.testing.calculator_quiz.repository;

import com.testing.calculator_quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT t FROM USERS t WHERE t.userId = :userId")
    User getUser(int userId);

    @Modifying
    @Query("INSERT INTO USERS (email) VALUES (:email)")
    void insertUser(@Param("email") String email);
}