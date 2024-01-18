package com.sidd.quiz.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sidd.quiz.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
List<Question> findByCategory(String category);
}
