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

    @GetMapping("/question/generate")
     ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam final String categoryName,
                                                             @RequestParam final Integer numQuestions);

    @PostMapping("/question/getQuestions")
     ResponseEntity<List<QuestionDto>> findQuestionsByIds(@RequestBody final List<Integer> questionIds);

    @PostMapping("/question/getScore")
    ResponseEntity<Integer> getScore(@RequestBody final List<Response> responses);

}
