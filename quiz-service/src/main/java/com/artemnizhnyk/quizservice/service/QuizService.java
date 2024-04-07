package com.artemnizhnyk.quizservice.service;

import com.artemnizhnyk.quizservice.model.Question;
import com.artemnizhnyk.quizservice.repository.QuizRepository;
import com.artemnizhnyk.quizservice.repository.QuizRepository;
import com.artemnizhnyk.quizservice.web.dto.QuestionDto;
import com.artemnizhnyk.quizservice.model.Quiz;
import com.artemnizhnyk.quizservice.web.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuizService {
    private final QuizRepository quizRepository;


    public ResponseEntity<String> createQuiz(final String category,
                                             final int numQ,
                                             final String title) {
//        List<Integer> questionIds =

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionDto>> getQuizQuestions(final Integer id) {
        List<QuestionDto> questionsForUser = new ArrayList<>();


        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(final Integer id, final List<Response> responses) {
        Quiz quiz = quizRepository.findById(id).get();
        int right = 0;
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
