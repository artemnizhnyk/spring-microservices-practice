package com.artemnizhnyk.quizservice.web.dto;

import lombok.Data;

@Data
public class QuizDto {

    private String categoryName;
    private Integer numQuestions;
    private String title;
}
