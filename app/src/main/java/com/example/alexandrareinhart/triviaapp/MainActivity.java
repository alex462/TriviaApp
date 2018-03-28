package com.example.alexandrareinhart.triviaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements CallbackFragment.CallbackClass {

    private QuestionCreatorFragment questionCreatorFragment;
    private CallbackFragment callbackFragment;
    List<String> quizQuestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.add_question_button)
    protected void addQuestionClicked(View view){
        questionCreatorFragment = QuestionCreatorFragment.newInstance();
//        questionCreatorFragment.attachView(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, questionCreatorFragment).commit();
    }

    @Override
    public void submitButtonClicked() {

    }
}
