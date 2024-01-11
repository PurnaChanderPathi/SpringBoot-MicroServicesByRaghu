package com.purna.quizapp.repository;

import com.purna.quizapp.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Questions,Integer> {
    List<Questions> findByCategory(String category);
    @Query(value = "SELECT * FROM quiz_table q where q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Questions> findRandomQuestionsByCategory(String category, int numQ);
}
