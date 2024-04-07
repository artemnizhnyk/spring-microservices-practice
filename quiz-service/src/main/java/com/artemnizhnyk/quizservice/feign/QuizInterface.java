package com.artemnizhnyk.quizservice.feign;

import com.artemnizhnyk.quizservice.web.dto.QuestionDto;
import com.artemnizhnyk.quizservice.web.dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("/generate")
     ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam final String categoryName,
                                                             @RequestParam final Integer numQuestions);

    @PostMapping("/getQuestions")
     ResponseEntity<List<QuestionDto>> findQuestionsById(@RequestBody final List<Integer> questionIds);

    @PostMapping("/getScore")
    ResponseEntity<Integer> getScore(@RequestBody final List<Response> responses);

}
