package com.sidd.quiz.model;

 import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Quiz")   
public class Quiz {
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY )
private Integer Qid;
private String title;

@ManyToMany
private List<Question>  questions;

public Integer getQid() {
	return Qid;
} 
public void setQid(Integer qid) {
	Qid = qid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public List<Question> getQuestions() {
	return questions;
}
public void setQuestions(List<Question> queList) {
	this.questions = queList;
}

	
}
