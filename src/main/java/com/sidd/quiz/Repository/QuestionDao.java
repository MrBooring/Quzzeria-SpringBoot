package com.sidd.quiz.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sidd.quiz.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
List<Question> findByCategory(String category);

@Query(value = "SELECT * FROM question WHERE category = :questionCategories ORDER BY RAND() LIMIT :noOfQuestion", nativeQuery = true)
List<Question> findRandomQuestionByCategory(String questionCategories, int noOfQuestion);

}
 