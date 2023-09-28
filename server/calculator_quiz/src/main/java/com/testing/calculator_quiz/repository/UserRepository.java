package com.testing.calculator_quiz.repository;

import com.testing.calculator_quiz.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Integer> {

    @Query("SELECT t FROM USERS t WHERE t.userId = :userId")
    User getUser(int userId);

//    @Modifying
//    @Query("INSERT INTO USERS(USER_ID, EMAIL) VALUES (:userId, :email)")
//    void setUser(int userId, String email);
}