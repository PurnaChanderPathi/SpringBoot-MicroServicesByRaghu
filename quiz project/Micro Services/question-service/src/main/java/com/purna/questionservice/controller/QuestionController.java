package com.purna.questionservice.controller;

import com.purna.questionservice.entity.QuestionWrapper;
import com.purna.questionservice.entity.Questions;
import com.purna.questionservice.entity.Response;
import com.purna.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private Environment environment;
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

    //generate
    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
        (@RequestParam String categoryName, @RequestParam Integer numQuestions )
    {
     return  questionService.getQuestionsForQuiz(categoryName,numQuestions);
    }

    //getQuestions (questionsId)
    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds)
    {
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionsFromId(questionIds);
    }

    //getScore
    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScores(@RequestBody List<Response> responses)
    {
        return questionService.getScore(responses);
    }
}
