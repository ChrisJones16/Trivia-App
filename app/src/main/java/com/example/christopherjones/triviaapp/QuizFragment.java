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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.christopherjones.triviaapp.MainActivity.QUESTIONS_LIST;

public class QuizFragment extends Fragment {

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

    private List<Question> questionList;
    private Question question;
    private int questionListPosition = 0;
    private int correctAnswers = 0;
    private QuizCallback quizCallback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_take_quiz, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static QuizFragment newInstance() {

        Bundle args = new Bundle();

        QuizFragment fragment = new QuizFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        questionList = getArguments().getParcelableArrayList(QUESTIONS_LIST);
        populateQuizContent();
    }

    private void populateQuizContent() {
        question = questionList.get(questionListPosition);
        quizQuestion.setText(question.getQuestion());

        List<Button> buttonList = new ArrayList<>();
        buttonList.add(answerButton);
        buttonList.add(answerButton2);
        buttonList.add(answerButton3);
        buttonList.add(answerButton4);
        //Just like with the buttons, this arrayList will take all of the possible answers and allow us to access them
        List<String> possibleAnswerList = new ArrayList<>();
        possibleAnswerList.add(question.getCorrectAnswer());
        possibleAnswerList.add(question.getWrongAnswer());
        possibleAnswerList.add(question.getWrongAnswer2());
        possibleAnswerList.add(question.getWrongAnswer3());
        //This For Each loop takes the arrayLists we made and actually allows us to randomize what question goes on which button

        for (Button button : buttonList) {
            //Creates a random number that will allow us to pick an answer from our arraylist
            int random = (int) Math.ceil(Math.random() * (possibleAnswerList.size() - 1));
            //Using the random number above we will set the text of the button by getting that item from the possible answers list
            button.setText(possibleAnswerList.get(random));
            //To make sure we don't use the same answer twice we remove the possible answer from the list
            possibleAnswerList.remove(random);

        }

    }

    private void checkAnswer(String answer){
        disableAnswerButton();
        //increments questionListPosition so we can go to the next question
        questionListPosition++;
        if(question.getCorrectAnswer().equals(answer)) {
            //Sets the textView to show the user they were correct
            quizQuestion.setText(R.string.correct);
            //increments the correct answers the user has gotten
            correctAnswers++;
        } else {
            quizQuestion.setText(getString(R.string.wrong_answer_text, question.getCorrectAnswer()));
        }
    }

    public void attachedparent(QuizCallback quizCallback) {
        this.quizCallback = quizCallback;

    }

    @OnClick(R.id.answer_1_button)
    protected void button1Clicked() {

        checkAnswer(answerButton.getText().toString());

    }
    @OnClick(R.id.answer_2_button)
    protected void button2Clicked() {

        checkAnswer(answerButton2.getText().toString());
    }

    @OnClick(R.id.answer_3_button)
    protected void button3Clicked() {

        checkAnswer(answerButton3.getText().toString());
    }

    @OnClick(R.id.answer_4_button)
    protected void button4Clicked() {

        checkAnswer(answerButton4.getText().toString());
    }

    @OnClick(R.id.next_button)
    protected void nextButtonClicked() {

        enableAnswerButton();

        if (questionListPosition  <= questionList.size() -1) {
            populateQuizContent();
        } else {
            //handles no more questions, takes user back to mainActivity
            quizCallback.quizFinish(correctAnswers);
        }
    }

    private void disableAnswerButton() {
        answerButton.setEnabled(false);
        answerButton2.setEnabled(false);
        answerButton3.setEnabled(false);
        answerButton4.setEnabled(false);
    }

    private void enableAnswerButton() {
        answerButton.setEnabled(true);
        answerButton2.setEnabled(true);
        answerButton3.setEnabled(true);
        answerButton4.setEnabled(true);
    }

    public interface QuizCallback {

        void quizFinish(int correctAnswers);
    }

}
