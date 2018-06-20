package com.example.christopherjones.triviaapp;

public class Question {

    //variables
    private String question;
    private String correctAnswer;
    private String wrongAnswer;
    private String wrongAnswer2;
    private String wrongAnswer3;

   //Constructor
    public Question(String question, String correctAnswer, String wrongAnswer, String wrongAnswer2, String wrongAnswer3) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
        this.wrongAnswer2 = wrongAnswer2;
        this.wrongAnswer3 = wrongAnswer3;
    }

    //Only Getters
    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getWrongAnswer() {
        return wrongAnswer;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }

    public String getWrongAnswer3() {
        return wrongAnswer3;
    }


}
