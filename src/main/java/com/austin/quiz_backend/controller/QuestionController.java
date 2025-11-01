package com.austin.quiz_backend.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.austin.quiz_backend.model.Questions;
import com.austin.quiz_backend.service.QuestionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private  QuestionService questionService;

    @GetMapping("/allQuestions")
    public List <Questions> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Questions> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

}
