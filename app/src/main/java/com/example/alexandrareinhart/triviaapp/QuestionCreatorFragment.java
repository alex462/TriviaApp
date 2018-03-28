package com.example.alexandrareinhart.triviaapp;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionCreatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionCreatorFragment extends Fragment {


    private Callback callback;


    @BindView(R.id.question_editText)
    protected EditText quizQuestionInput;
    @BindView(R.id.correct_answer_editText)
    protected EditText correctAnswer;
    @BindView(R.id.incorrect_answerOne_editText)
    protected EditText incorrectAnswerOne;
    @BindView(R.id.incorrect_answerTwo_editText)
    protected EditText incorrectAnswerTwo;
    @BindView(R.id.incorrect_answerThree_editText)
    protected EditText incorrectAnswerThree;



    public EditText getQuestionEditText() {
        quizQuestionInput.toString();
        return quizQuestionInput;
    }

    public EditText getCorrectAnswerEditText() {
        correctAnswer.toString();
        return correctAnswer;
    }

    public EditText getIncorrectAnswerOneEditText() {
        incorrectAnswerOne.toString();
        return incorrectAnswerOne;
    }

    public EditText getIncorrectAnswerTwoEditText() {
        incorrectAnswerTwo.toString();
        return incorrectAnswerTwo;
    }

    public EditText getIncorrectAnswerThreeEditText() {
        incorrectAnswerThree.toString();
        return incorrectAnswerThree;
    }



    public static QuestionCreatorFragment newInstance() {

        QuestionCreatorFragment fragment = new QuestionCreatorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @OnClick(R.id.submit_button)
    protected void submitButtonClicked(){

        if(quizQuestionInput.getText().toString().isEmpty() || correctAnswer.getText().toString().isEmpty() || incorrectAnswerOne.getText().toString().isEmpty() || incorrectAnswerTwo.getText().toString().isEmpty() || incorrectAnswerThree.getText().toString().isEmpty()){
            Toast.makeText(getActivity(), "ALL FIELDS ARE REQUIRED", Toast.LENGTH_LONG).show();
        }
        else {
            String quizQuestion = quizQuestionInput.getText().toString();
            String correct = correctAnswer.getText().toString();
            String firstIncorrect = incorrectAnswerOne.getText().toString();
            String secondIncorrect = incorrectAnswerTwo.getText().toString();
            String thirdIncorrect = incorrectAnswerThree.getText().toString();

            Question question = new Question(quizQuestion, correct, firstIncorrect, secondIncorrect, thirdIncorrect);

            callback.saveQuestion(question);
        }
    }

    public interface Callback{
        void saveQuestion(Question question);


    }

    public void attachView(Callback callback){
        this.callback = callback;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_creator, container,false);
        //this says i want to create a view, layout "inflater", with ViewGroup "container" and i DON'T want it to be the root/i want to control it.
        ButterKnife.bind(this, view);
        return view; //return the xml view that i made
    }

}
