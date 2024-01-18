package com.sidd.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation;

import com.sidd.quiz.model.Question;
import com.sidd.quiz.service.QuestionService;

@RestController
@RequestMapping("question") 
public class QuestionController {
	@Autowired
	QuestionService questionService ;
	
	@GetMapping("allQuestions")
	 public List<Question> getAllQuestion() {
		 return questionService.getAllQuestions();
	 }
	
	@GetMapping("category/{category}")
	public List<Question> getQuestionByCategory(@PathVariable String category){
		
		return questionService.getQuestionsByCategories(category);
		
	}
	
//	@PostMapping("addQuestion")
//	public String addQuestion(@RequestBody Question newQuestion) {
//		questionService.addQuestion();
//		
//		return "done";
//	}
}
