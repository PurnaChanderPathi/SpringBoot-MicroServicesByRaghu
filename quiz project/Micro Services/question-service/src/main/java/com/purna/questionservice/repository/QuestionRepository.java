package com.purna.questionservice.repository;

import com.purna.questionservice.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Questions,Integer> {
    List<Questions> findByCategory(String category);
    @Query(value = "SELECT q.id FROM questions q where q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
