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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionCreatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionCreatorFragment extends Fragment {

    private CallbackFragment callbackFragment;

    public QuestionCreatorFragment() {
        // Required empty public constructor
    }


    protected EditText questionEditText;
    protected EditText correctAnswerEditText;
    protected EditText incorrectAnswerOneEditText;
    protected EditText incorrectAnswerTwoEditText;
    protected EditText incorrectAnswerThreeEditText;
    protected Button submitButton;

    @SuppressLint("ValidFragment")
    public QuestionCreatorFragment(EditText questionEditText, EditText correctAnswerEditText, EditText incorrectAnswerOneEditText, EditText incorrectAnswerTwoEditText, EditText incorrectAnswerThreeEditText) {
        this.questionEditText = questionEditText;
        this.correctAnswerEditText = correctAnswerEditText;
        this.incorrectAnswerOneEditText = incorrectAnswerOneEditText;
        this.incorrectAnswerTwoEditText = incorrectAnswerTwoEditText;
        this.incorrectAnswerThreeEditText = incorrectAnswerThreeEditText;
    }

    public EditText getQuestionEditText() {
        questionEditText.toString();
        return questionEditText;
    }

    public EditText getCorrectAnswerEditText() {
        correctAnswerEditText.toString();
        return correctAnswerEditText;
    }

    public EditText getIncorrectAnswerOneEditText() {
        incorrectAnswerOneEditText.toString();
        return incorrectAnswerOneEditText;
    }

    public EditText getIncorrectAnswerTwoEditText() {
        incorrectAnswerTwoEditText.toString();
        return incorrectAnswerTwoEditText;
    }

    public EditText getIncorrectAnswerThreeEditText() {
        incorrectAnswerThreeEditText.toString();
        return incorrectAnswerThreeEditText;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public static QuestionCreatorFragment newInstance() {

        QuestionCreatorFragment fragment = new QuestionCreatorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
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
