package com.example.christopherjones.triviaapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable {

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

    protected Question(Parcel in) {
        question = in.readString();
        correctAnswer = in.readString();
        wrongAnswer = in.readString();
        wrongAnswer2 = in.readString();
        wrongAnswer3 = in.readString();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(question);
        parcel.writeString(correctAnswer);
        parcel.writeString(wrongAnswer);
        parcel.writeString(wrongAnswer2);
        parcel.writeString(wrongAnswer3);
    }
}
