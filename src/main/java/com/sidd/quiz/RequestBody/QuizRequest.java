package com.sidd.quiz.RequestBody;

public class QuizRequest {
private int NoOfQuestion;
private String quizTitle;
private String QuestionCategories;

public int getNoOfQuestion() {
	return NoOfQuestion;
}
public void setNoOfQuestion(int noOfQuestion) {
	NoOfQuestion = noOfQuestion;
}
public String getquizTitle() {
	return quizTitle;
}
public void setquizTitle(String questionTitle) {
	quizTitle = questionTitle;
}
public String getQuestionCategories() {
	return QuestionCategories;
}
public void setQuestionCategories(String questionCategories) {
	QuestionCategories = questionCategories;
}



}
