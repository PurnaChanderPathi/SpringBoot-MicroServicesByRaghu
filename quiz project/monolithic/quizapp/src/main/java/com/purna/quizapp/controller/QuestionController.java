package com.purna.quizapp.controller;

import com.purna.quizapp.entity.QuestionWrapper;
import com.purna.quizapp.entity.Questions;
import com.purna.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions()
    {
        return questionService.getAllQuestions();
    }

    @PostMapping("/saveQuestions")
    public ResponseEntity<Questions> saveQuestions(@RequestBody Questions questions)
    {
        return  questionService.saveQuestions(questions);

    }

    @GetMapping("/findByCategory/{category}")
    public ResponseEntity<List<Questions>> getQuestionByCategory(@PathVariable String category)
    {
        return questionService.getQuestionByCategory(category);

    }

}
