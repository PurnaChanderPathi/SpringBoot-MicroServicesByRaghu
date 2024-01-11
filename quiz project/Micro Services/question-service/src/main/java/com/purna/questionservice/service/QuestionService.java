package com.purna.questionservice.service;


import com.netflix.discovery.converters.Auto;
import com.purna.questionservice.entity.QuestionWrapper;
import com.purna.questionservice.entity.Questions;
import com.purna.questionservice.entity.Response;
import com.purna.questionservice.repository.QuestionRepository;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
        List<Integer> questions = questionRepository.findRandomQuestionsByCategory(categoryName, numQuestions);
        return new ResponseEntity<>(questions,HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
        List<QuestionWrapper> questionWrappers = new ArrayList<>();
        List<Questions> questions = new ArrayList<>();

        for(Integer id:questionIds)
        {
            questions.add(questionRepository.findById(id).get());
        }

        for(Questions question:questions)
        {
            QuestionWrapper questionWrapper = new QuestionWrapper();
            questionWrapper.setId(question.getId());
            questionWrapper.setQuestionTitle(question.getQuestionTitle());
            questionWrapper.setOption1(question.getOption1());
            questionWrapper.setOption2(question.getOption2());
            questionWrapper.setOption3(question.getOption3());
            questionWrapper.setOption4(question.getOption4());
            questionWrappers.add(questionWrapper);
        }
        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }
    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int right =0;
        for(Response response:responses)
        {
            Questions questions = questionRepository.findById(response.getId()).get();
            if(response.getResponse().equals(questions.getRightAnswer()))
                right++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
