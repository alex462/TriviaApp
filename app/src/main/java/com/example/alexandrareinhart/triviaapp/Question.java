package com.example.alexandrareinhart.triviaapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;
import android.widget.TextView;

public class Question implements Parcelable {


    protected String quizQuestionInput;
    protected String correctAnswer;
    protected String incorrectAnswerOne;
    protected String incorrectAnswerTwo;
    protected String incorrectAnswerThree;

//    public Question(EditText quizQuestionInput, EditText correctAnswer, EditText incorrectAnswerOne, EditText incorrectAnswerTwo, EditText incorrectAnswerThree) {
//        this.quizQuestionInput = quizQuestionInput;
//        this.correctAnswer = correctAnswer;
//        this.incorrectAnswerOne = incorrectAnswerOne;
//        this.incorrectAnswerTwo = incorrectAnswerTwo;
//        this.incorrectAnswerThree = incorrectAnswerThree;
//    }


    public Question(String quizQuestionInput, String correctAnswer, String incorrectAnswerOne, String incorrectAnswerTwo, String incorrectAnswerThree) {
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

    public String getQuizQuestionInput() {
//        quizQuestionInput.toString();
        return quizQuestionInput;
    }

    public String getCorrectAnswer() {
//        correctAnswer.toString();
        return correctAnswer;
    }

    public String getIncorrectAnswerOne() {
//        incorrectAnswerOne.toString();
        return incorrectAnswerOne;
    }

    public String getIncorrectAnswerTwo() {
//        incorrectAnswerTwo.toString();
        return incorrectAnswerTwo;
    }

    public String getIncorrectAnswerThree() {
//        incorrectAnswerThree.toString();
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




