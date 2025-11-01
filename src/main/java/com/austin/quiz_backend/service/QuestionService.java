package com.austin.quiz_backend.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.austin.quiz_backend.dao.QuestionDao;
import com.austin.quiz_backend.model.Questions;
@Service
public class QuestionService {
    @Autowired
    private  QuestionDao questionDao;

    public ResponseEntity <List<Questions>> getAllQuestions(){
      try{ 
      return new ResponseEntity<> (questionDao.findAll(), HttpStatus.OK);
      }catch(Exception e){
        e.printStackTrace();
      }
      return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity <List<Questions>> getQuestionsByCategory(String category) {
      try{ 
       return new ResponseEntity<> (questionDao.findByCategory(category), HttpStatus.OK);
      }catch(Exception e){
        e.printStackTrace();
      }
      return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity <String> addQuestion(Questions questions) {
      questionDao.save(questions); 
      return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
    }

}
