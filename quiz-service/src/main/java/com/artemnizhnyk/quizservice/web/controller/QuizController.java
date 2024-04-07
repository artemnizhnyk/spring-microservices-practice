package com.artemnizhnyk.quizservice.web.controller;

import com.artemnizhnyk.quizservice.service.QuizService;
import com.artemnizhnyk.quizservice.web.dto.QuestionDto;
import com.artemnizhnyk.quizservice.web.dto.QuizDto;
import com.artemnizhnyk.quizservice.web.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("quiz")
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam final QuizDto quizDto) {
        return quizService.createQuiz(
                quizDto.getCategoryName(),
                quizDto.getNumQuestions(),
                quizDto.getTitle()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionDto>> getQuizQuestions(@PathVariable final Integer id) {
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable final Integer id,
                                              @RequestBody final List<Response> responses) {
        return quizService.calculateResult(id, responses);
    }


}
