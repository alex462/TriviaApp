package com.example.alexandrareinhart.triviaapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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



    public QuestionCreatorFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.question_editText)
    protected EditText questionEditText;

    @BindView(R.id.correct_answer_editText)
    protected EditText correctAnswerEditText;

    @BindView(R.id.incorrect_answerOne_editText)
    protected EditText incorrectAnswerOneEditText;

    @BindView(R.id.incorrect_answerTwo_editText)
    protected EditText incorrectAnswerTwoEditText;

    @BindView(R.id.incorrect_answerThree_editText)
    protected EditText incorrectAnswerThreeEditText;

    @OnClick(R.id.submit_button)
    protected void onSubmitButtonClicked(View view){
        //TODO create a method/fragment to store question and answer objects to arraylists
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
