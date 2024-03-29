package com.sidd.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation;

import com.sidd.quiz.model.Question;
import com.sidd.quiz.service.QuestionService;

@RestController
@RequestMapping("/user/question") 
public class QuestionController {
	@Autowired
	QuestionService questionService ;
	
	@GetMapping("allQuestions")
	 public ResponseEntity<List<Question>>getAllQuestion() {
		
		return questionService.getAllQuestions();
	 }
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
		
		return questionService.getQuestionsByCategories(category);
		
	}
	
	@PostMapping("/category")
	public ResponseEntity<List<Question>> getQuestionByCategoryparam(@RequestBody Question question){
		
		return questionService.getQuestionsByCategories(question.getCategory());
		
	}
	
//	@PostMapping("addQuestion")
//	public ResponseEntity<String> addQuestion(@RequestBody Question newQuestion) {
//		return questionService.addQuestion(newQuestion);
//	 
//	}
	
	
}


@RestController
@RequestMapping("/admin/question")
class AdminQuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestionAsAdmin(@RequestBody Question newQuestion) {
        // Additional logic for admin-specific functionality
        return questionService.addQuestion(newQuestion);
    }
}
