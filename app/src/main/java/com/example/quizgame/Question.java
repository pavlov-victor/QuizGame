package com.example.quizgame;

public class Question {

    String question;
    String [] variants;
    String rightAnswer;


    public Question(String question, String[] variants, String rightAnswer) {
        this.question = question;
        this.variants = variants;
        this.rightAnswer = rightAnswer;
    }
}
