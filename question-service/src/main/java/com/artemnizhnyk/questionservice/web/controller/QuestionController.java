package com.artemnizhnyk.questionservice.web.controller;


import com.artemnizhnyk.questionservice.model.Question;
import com.artemnizhnyk.questionservice.web.dto.Response;
import com.artemnizhnyk.questionservice.service.QuestionService;
import com.artemnizhnyk.questionservice.web.dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/question")
@RestController
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable final String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody final Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam final String categoryName,
                                                             @RequestParam final Integer numQuestions) {
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionDto>> findQuestionsById(@RequestBody final List<Integer> questionIds) {
        return questionService.findQuestionsById(questionIds);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody final List<Response> responses) {
        return questionService.getScore(responses);
    }
}
