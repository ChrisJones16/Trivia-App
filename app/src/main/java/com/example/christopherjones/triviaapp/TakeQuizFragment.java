package com.example.christopherjones.triviaapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TakeQuizFragment extends Fragment {

    @BindView(R.id.question_textview)
    protected TextView quizQuestion;

    @BindView(R.id.answer_1_button)
    protected Button answerButton;

    @BindView(R.id.answer_2_button)
    protected Button answerButton2;

    @BindView(R.id.answer_3_button)
    protected Button answerButton3;

    @BindView(R.id.answer_4_button)
    protected Button answerButton4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_take_quiz, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static TakeQuizFragment newInstance() {

        Bundle args = new Bundle();

        TakeQuizFragment fragment = new TakeQuizFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @OnClick(R.id.answer_1_button)
    protected void button1Clicked() {


    }
    @OnClick(R.id.answer_2_button)
    protected void button2Clicked() {

    }

    @OnClick(R.id.answer_3_button)
    protected void button3Clcked() {

    }

    @OnClick(R.id.answer_4_button)
    protected void button4Clicked() {

    }

    @OnClick(R.id.next_button)
    protected void nextButtonClicked() {

    }

}
