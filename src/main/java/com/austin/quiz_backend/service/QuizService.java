package com.austin.quiz_backend.service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.austin.quiz_backend.dao.QuestionDao;
import com.austin.quiz_backend.dao.QuizDao;
import com.austin.quiz_backend.model.QuestionWrapper;
import com.austin.quiz_backend.model.Questions;
import com.austin.quiz_backend.model.Quiz;
import com.austin.quiz_backend.model.Response;
@Service
public class QuizService {
 @Autowired   
 private QuizDao quizDao;
@Autowired
 private QuestionDao questionDao;

 public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
  List<Questions> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

  Quiz quiz = new Quiz();
  quiz.setTitle(title);
  quiz.setQuestions(questions);
  quizDao.save(quiz);
  return ResponseEntity.ok("Quiz created successfully");
 }

 public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
    Optional <Quiz> quiz = quizDao.findById(id);
    List<Questions> questionsFromDb = quiz.get().getQuestions();
    List<QuestionWrapper> questionsForUser = new ArrayList<>();
    for (Questions q : questionsFromDb) {
        QuestionWrapper qw = new QuestionWrapper(
            q.getId(),
            q.getQuestionTitle(),
            q.getOption1(),
            q.getOption2(),
            q.getOption3(),
            q.getOption4()
        );
        questionsForUser.add(qw);
    }
    return ResponseEntity.ok(questionsForUser);
}

 public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
 
   Quiz quiz = quizDao.findById(id).get();
   List<Questions> questions = quiz.getQuestions();
   int right = 0;
   int i = 0;
   for(Response response : responses){
      if(response.getResponse().equals(questions.get(i).getRightAnswer())){
         right++;
      }
      i++;
   }
   return new ResponseEntity<>(right,HttpStatus.OK);
 }
}