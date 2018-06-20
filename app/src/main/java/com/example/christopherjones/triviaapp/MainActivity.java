package com.example.christopherjones.triviaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements QuestionCreatorFragment.Callback{

    private QuestionCreatorFragment questionCreatorFragment;

    private List<Question>questionList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        questionList = new ArrayList<>();
    }

    @OnClick(R.id.add_question_button)
    protected void addquestionClicked() {

       questionCreatorFragment = QuestionCreatorFragment.newInstance();
       questionCreatorFragment.attachParent(this);
       getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, questionCreatorFragment).commit();

    }

    @Override
    public void questionSaved(Question question) {
        //Takes the question object that was passed in and saves it to the question ArrayList
        questionList.add(question);
        //Shows a Toast to the user that lets them know the question was saved.
        Toast.makeText(this, "Question Saved", Toast.LENGTH_SHORT).show();
        //Removes fragment from the frame layout
        getSupportFragmentManager().beginTransaction().remove(questionCreatorFragment).commit();
    }
}
