package com.austin.quiz_backend.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.austin.quiz_backend.model.Questions;
@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer>{

}
