package com.example.alexandrareinhart.triviaapp;

import android.os.Parcelable;
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
    protected void takeQuizClicked() {
        quizFragment = QuizFragment.newInstance();
        quizFragment.attachView(this);

        if (quizQuestions.isEmpty()) {
            Toast.makeText(this, "You have not added any questions yet!", Toast.LENGTH_LONG).show();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, quizFragment).commit();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(QUESTIONS_LIST, (ArrayList<? extends Parcelable>) quizQuestions);
            quizFragment.setArguments(bundle);
        }
    }

    @OnClick(R.id.delete_quiz_button)
    protected void deleteQuizClicked() {
        if (quizQuestions.isEmpty()) {
            Toast.makeText(this, "There are no questions to delete!", Toast.LENGTH_LONG).show();
        } else {
            //TODO alert dialog to make sure user wants to delete quiz and logic to make that happen, Toast when complete.
        }
    }


    @Override
    public void saveQuestion(Question question){
        quizQuestions.add(question);
        Toast.makeText(this, "QUESTION ADDED", Toast.LENGTH_LONG).show();
        getSupportFragmentManager().beginTransaction().remove(questionCreatorFragment).commit();
    }

    public void quizFinished(int scoreCorrect){

    }


}
