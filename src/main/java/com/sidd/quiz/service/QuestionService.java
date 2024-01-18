package com.sidd.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidd.quiz.Dao.QuestionDao;
import com.sidd.quiz.model.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao ;

	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return questionDao.findAll();
	}

	public List<Question> getQuestionsByCategories(String category) {
		// TODO Auto-generated method stub
		return questionDao.findByCategory(category) ;
	}

	
}
