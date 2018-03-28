package com.example.alexandrareinhart.triviaapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.widget.EditText;

import com.example.alexandrareinhart.triviaapp.CallbackFragment.CallbackClass;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import static java.util.Collections.*;

public class Question implements Parcelable {


    protected EditText quizQuestionInput;
    protected EditText correctAnswer;
    protected EditText incorrectAnswerOne;
    protected EditText incorrectAnswerTwo;
    protected EditText incorrectAnswerThree;

    public Question(EditText quizQuestionInput, EditText correctAnswer, EditText incorrectAnswerOne, EditText incorrectAnswerTwo, EditText incorrectAnswerThree) {
        this.quizQuestionInput = quizQuestionInput;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswerOne = incorrectAnswerOne;
        this.incorrectAnswerTwo = incorrectAnswerTwo;
        this.incorrectAnswerThree = incorrectAnswerThree;
    }

    protected Question(Parcel in) {
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public EditText getQuizQuestionInput() {
        quizQuestionInput.toString();
        return quizQuestionInput;
    }

    public EditText getCorrectAnswer() {
        correctAnswer.toString();
        return correctAnswer;
    }

    public EditText getIncorrectAnswerOne() {
        incorrectAnswerOne.toString();
        return incorrectAnswerOne;
    }

    public EditText getIncorrectAnswerTwo() {
        incorrectAnswerTwo.toString();
        return incorrectAnswerTwo;
    }

    public EditText getIncorrectAnswerThree() {
        incorrectAnswerThree.toString();
        return incorrectAnswerThree;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

}




