package com.purna.quizapp.service;

import com.purna.quizapp.entity.Questions;
import com.purna.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<List<Questions>> getAllQuestions()
    {
        List<Questions> all = questionRepository.findAll();
        return new ResponseEntity<>(  all, HttpStatus.OK);
    }

    public ResponseEntity<Questions> saveQuestions(Questions questions)
    {
        Questions save = questionRepository.save(questions);
        return new ResponseEntity<>( save,HttpStatus.CREATED);
    }

    public ResponseEntity<List<Questions>> getQuestionByCategory(String category)
    {
        List<Questions> findCategory = questionRepository.findByCategory(category);
        return new ResponseEntity<>(findCategory,HttpStatus.OK);
    }

}
