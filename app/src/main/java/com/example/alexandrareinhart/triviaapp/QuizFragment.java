package com.example.alexandrareinhart.triviaapp;

import android.os.Bundle;
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

public class QuizFragment extends Fragment{

    @BindView(R.id.question_textView)
    protected TextView quizQuestion;
    @BindView(R.id.a_answer_button)
    protected Button aButton;
    @BindView(R.id.b_answer_button)
    protected Button bButton;
    @BindView(R.id.c_answer_button)
    protected Button cButton;
    @BindView(R.id.d_answer_button)
    protected Button dButton;
    @BindView(R.id.next_question_button)
    protected Button nextButton;


    private QuizCallback quizCallback;
    private List<Question> quizQuestions;

    public void attachView(QuizCallback quizCallback){
        this.quizCallback = quizCallback;
    }

    public interface QuizCallback{

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        ButterKnife.bind(this,view);
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
        quizQuestions = new ArrayList<>();
        quizQuestions =
    }



    private void populateQuizContent(){
        //TODO make work
    }

    private void checkAnswer(){
        //TODO make work
    }

    @OnClick(R.id.next_question_button)
    private void nextButtonClicked(){

    }


}
