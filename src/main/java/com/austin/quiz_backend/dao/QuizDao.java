package com.austin.quiz_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.austin.quiz_backend.model.Quiz;
@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
