package com.example.alexandrareinhart.triviaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements QuestionCreatorFragment.Callback, QuizFragment.QuizCallback{

    private QuestionCreatorFragment questionCreatorFragment;
    private QuizFragment quizFragment;
    private List<Question> quizQuestions;
    public static final String QUESTIONS_LIST = "questions_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        quizQuestions = new ArrayList<>();
    }

    @OnClick(R.id.add_question_button)
    protected void addQuestionClicked(View view){
        questionCreatorFragment = QuestionCreatorFragment.newInstance();
        questionCreatorFragment.attachView(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, questionCreatorFragment).commit();
    }

    @OnClick(R.id.take_quiz_button)
    protected void takeQuizClicked(){
        quizFragment = QuizFragment.newInstance();
        quizFragment.attachView(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, quizFragment).commit();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList();
    }


    @Override
    public void saveQuestion(Question question){
        quizQuestions.add(question);
        Toast.makeText(this, "QUESTION ADDED", Toast.LENGTH_LONG).show();
        getSupportFragmentManager().beginTransaction().remove(questionCreatorFragment).commit();
    }

    @Override
    public void submitButtonClicked() {

    }

    public interface Callback{
        void submitButtonClicked();
    }
}
