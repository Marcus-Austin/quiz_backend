package com.austin.quiz_backend.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.austin.quiz_backend.dao.QuestionDao;
import com.austin.quiz_backend.model.Questions;
@Service
public class QuestionService {
    @Autowired
    private  QuestionDao questionDao;

    public List<Questions> getAllQuestions(){
      return questionDao.findAll();
    }

}
