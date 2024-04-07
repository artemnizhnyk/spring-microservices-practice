package com.artemnizhnyk.questionservice.service;

import com.artemnizhnyk.questionservice.model.Question;
import com.artemnizhnyk.questionservice.repository.QuestionRepository;
import com.artemnizhnyk.questionservice.web.dto.QuestionDto;
import com.artemnizhnyk.questionservice.web.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(final String category) {
        try {
            return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(final Question question) {
        questionRepository.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(final String categoryName, final Integer numQuestions) {
        List<Integer> questions = questionRepository.findRandomQuestionsByCategory(categoryName, numQuestions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionDto>> getQuestionsFromId(final List<Integer> questionIds) {
        List<Question> questions = new ArrayList<>();
        questionIds.forEach(q -> questions.add(questionRepository.findById(q).get()));
        List<QuestionDto> questionDtos = questions.stream()
                .map(q -> {
                    QuestionDto dto = new QuestionDto(
                            q.getId(),
                            q.getQuestionTitle(),
                            q.getOption1(),
                            q.getOption2(),
                            q.getOption3(),
                            q.getOption4()
                    );
                    return dto;
                })
                .toList();
        return new ResponseEntity<>(questionDtos, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(final List<Response> responses) {
        int right = 0;
        for(Response response : responses){
            Question question = questionRepository.findById(response.getId()).get();
            if(response.getResponse().equals(question.getRightAnswer()))
                right++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
