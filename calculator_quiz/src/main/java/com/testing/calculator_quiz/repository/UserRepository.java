package com.testing.calculator_quiz.repository;

import com.testing.calculator_quiz.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Integer> {

    @Query("SELECT t FROM USERS t WHERE t.userId = :userId")
    User getUser(int userId);

//    @Query("SELECT t FROM USERS t WHERE t.userId = :userId")
//    User setUser(int userId);
}
