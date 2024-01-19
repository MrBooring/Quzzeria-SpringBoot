package com.sidd.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sidd.quiz.Dao.QuestionDao;
import com.sidd.quiz.Dao.QuizDao;
import com.sidd.quiz.model.Question;
import com.sidd.quiz.model.Quiz;
import com.sidd.quiz.responseBody.QuestionResponse;

import RequestBody.QuizRequest;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<String>createQuiz(QuizRequest quizRequest) {
		 try {
			 	Quiz quiz = new Quiz();
			 	List<Question> questions = questionDao.findRandomQuestionByCategory(quizRequest.getQuestionCategories() , quizRequest.getNoOfQuestion() );
 
			 	if(questions.isEmpty() ) {
	                return new ResponseEntity<>("No questions found", HttpStatus.NOT_FOUND);
			 	}
			 	
			 	quiz.setTitle(quizRequest.getquizTitle() );
			 	quiz.setQuestions(questions); 

			 quizDao.save(quiz);
			 return new ResponseEntity<>( "Success" , HttpStatus.CREATED ); 
//			 quizDao.
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST );
		
	}

	public ResponseEntity<List<Quiz>> getAllQuiz() {
 
	try {
	return new	 ResponseEntity<>(quizDao.findAll() , HttpStatus.OK);
	}catch(Exception e) {
		e.printStackTrace();
	}
	return new	 ResponseEntity<>(new ArrayList<>() , HttpStatus.BAD_REQUEST );
	}

	public ResponseEntity<List<QuestionResponse>> getQuizById(Integer id) {
		 Optional<Quiz> quiz = quizDao.findById(id);
		 
		 List<Question> questionFromDb = quiz.get().getQuestions();
		 List<QuestionResponse> questionForUser= new ArrayList<>();
		 for(Question q :questionFromDb) {
			 QuestionResponse qw = new QuestionResponse(q.getId(), q.getQuestionTitle(),q.getOption1(), q.getOption2(),q.getOption3(), q.getOption4(), q.getDifficultyLevel(), q.getCategory());
			 questionForUser.add(qw);
		 }
		return  new ResponseEntity<>(  questionForUser, HttpStatus.OK )  ;
	}
 

	
}
