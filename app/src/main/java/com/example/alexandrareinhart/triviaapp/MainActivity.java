package com.example.alexandrareinhart.triviaapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
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
            AlertDialog.Builder deleteDialog = new AlertDialog.Builder(this);
            deleteDialog.setMessage("ATTENTION! This will delete your ENTIRE quiz. Do you still want to delete this quiz?").setPositiveButton(R.string.delete_quiz, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    quizQuestions.clear();
                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, "The quiz has been deleted. There are no questions saved.", Toast.LENGTH_LONG).show();
                }
            });

        }
    }
//2buttons - confirm or dismiss

    @Override
    public void saveQuestion(Question question){
        quizQuestions.add(question);
        Toast.makeText(this, "QUESTION ADDED", Toast.LENGTH_LONG).show();
        getSupportFragmentManager().beginTransaction().remove(questionCreatorFragment).commit();
    }

    public void quizFinished(int scoreCorrect, int questionIndex){
        //TODO this is the method for the alert dialogue that will hold the score #correct/#total, then button option back to Main Activity.
        getSupportFragmentManager().beginTransaction().remove(quizFragment).commit();
        AlertDialog.Builder correctDialog = new AlertDialog.Builder(this);
        correctDialog.setMessage(getString(R.string.dialog_message, scoreCorrect, questionIndex));
        correctDialog.show();
    }


}
