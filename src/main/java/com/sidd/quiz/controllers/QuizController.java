package com.sidd.quiz.controllers;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import com.sidd.quiz.model.Quiz;
import com.sidd.quiz.responseBody.QuestionResponse;
import com.sidd.quiz.service.QuizService;

import RequestBody.QuizRequest;

@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
	 
	@PostMapping("createQuiz")
	public ResponseEntity<String> createQuiz(@RequestBody QuizRequest quizRequest ) {
		return quizService.createQuiz(quizRequest);
	}
	
	@GetMapping("getAllQuiz")
	public ResponseEntity<List<Quiz>>  getAllQuiz( ) {
		return quizService.getAllQuiz();
	}
	
	@GetMapping("getQuizById/{id}")
	public ResponseEntity<List<QuestionResponse > > getQuizById(@PathVariable Integer id ) {
		return quizService.getQuizById(id);
	}
	
	

}
