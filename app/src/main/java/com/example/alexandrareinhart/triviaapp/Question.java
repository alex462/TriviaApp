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



    private EditText quizQuestionInput;
    private EditText correctAnswer;
    private EditText incorrectAnswerOne;
    private EditText incorrectAnswerTwo;
    private EditText incorrectAnswerThree;

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
        return quizQuestionInput;
    }

    public EditText getCorrectAnswer() {
        return correctAnswer;
    }

    public EditText getIncorrectAnswerOne() {
        return incorrectAnswerOne;
    }

    public EditText getIncorrectAnswerTwo() {
        return incorrectAnswerTwo;
    }

    public EditText getIncorrectAnswerThree() {
        return incorrectAnswerThree;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        
    }

    //    private CallbackClass callback;

//
//    Array[] quizQuestion = new Array[5];
//
//    public void createQuizQuestion(){
//
//    }
//
//    public int[] shuffleAnswers(int[] array){
//        Random rgen = new Random();
//        for(int i=1; i<array.length; i++) {
//            int randomPosition = rgen.nextInt(array.length);
//            int temp = array[i];
//            array[i] = array[randomPosition];
//            array[randomPosition] = temp;
//        }
//        return array;
//
//        }
    }




