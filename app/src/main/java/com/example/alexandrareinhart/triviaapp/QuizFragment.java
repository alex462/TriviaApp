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

import static com.example.alexandrareinhart.triviaapp.MainActivity.QUESTIONS_LIST;

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
    private Question question;
    private int questionIndex = 0;
    private int scoreCorrect = 0;

    public void attachView(QuizCallback quizCallback){
        this.quizCallback = quizCallback;
    }

    public interface QuizCallback{

        void quizFinished(int scoreCorrect);
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
        quizQuestions = getArguments().getParcelableArrayList(QUESTIONS_LIST);
        populateQuizContent();

    }

    private void populateQuizContent(){
        aButton.setEnabled(true);
        bButton.setEnabled(true);
        cButton.setEnabled(true);
        dButton.setEnabled(true);
        nextButton.setEnabled(false);

        question = quizQuestions.get(questionIndex);

        quizQuestion.setText(question.getQuizQuestionInput().toString());
        List<Button> buttonList = new ArrayList<>();
        buttonList.add(aButton);
        buttonList.add(bButton);
        buttonList.add(cButton);
        buttonList.add(dButton);

        List<String> randomAnswerList = new ArrayList<>();
        randomAnswerList.add(question.getCorrectAnswer().toString());
        randomAnswerList.add(question.getIncorrectAnswerOne().toString());
        randomAnswerList.add(question.getIncorrectAnswerTwo().toString());
        randomAnswerList.add(question.getIncorrectAnswerThree().toString());

        for(Button button : buttonList){
            int random = (int) (Math.random() * randomAnswerList.size() - 1);
            button.setText(randomAnswerList.get(random));
            randomAnswerList.remove(random);
        }

    }

    @OnClick(R.id.a_answer_button)
    protected void aButtonClicked(){
        checkAnswer(aButton.getText().toString());
        bButton.setEnabled(false);
        cButton.setEnabled(false);
        dButton.setEnabled(false);
        nextButton.setEnabled(true);
    }

    @OnClick(R.id.b_answer_button)
    protected void bButtonClicked(){
        checkAnswer(bButton.getText().toString());
        aButton.setEnabled(false);
        cButton.setEnabled(false);
        dButton.setEnabled(false);
        nextButton.setEnabled(true);
    }

    @OnClick(R.id.c_answer_button)
    protected void cButtonClicked(){
        checkAnswer(cButton.getText().toString());
        aButton.setEnabled(false);
        bButton.setEnabled(false);
        dButton.setEnabled(false);
        nextButton.setEnabled(true);
    }

    @OnClick(R.id.d_answer_button)
    protected void dButtonClicked(){
        checkAnswer(dButton.getText().toString());
        aButton.setEnabled(false);
        bButton.setEnabled(false);
        cButton.setEnabled(false);
        nextButton.setEnabled(true);
    }

    private void checkAnswer(String answer){
        if(question.getCorrectAnswer().equals(answer))
        {
            quizQuestion.setText(R.string.correct);
            scoreCorrect++;
        }
        else{
//            String tempAnswer = question.getCorrectAnswer().toString();
            quizQuestion.setText(R.string.wrongwrong);
        }
        questionIndex++;
    }

    @OnClick(R.id.next_question_button)
    protected void nextButtonClicked(){
        if(questionIndex <= quizQuestions.size()-1){
            populateQuizContent();
        }
        else{
            quizCallback.quizFinished(scoreCorrect);
        }
    }


}
