package com.example.alexandrareinhart.triviaapp;

import android.support.annotation.NonNull;
import android.widget.EditText;

import com.example.alexandrareinhart.triviaapp.CallbackFragment.CallbackClass;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import static java.util.Collections.*;

public class Question extends QuestionCreatorFragment{

    private CallbackClass callback;


    List<String> list = new List<String>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<String> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] a) {
            return null;
        }

        @Override
        public boolean add(String s) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends String> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, @NonNull Collection<? extends String> c) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public String get(int index) {
            return null;
        }

        @Override
        public String set(int index, String element) {
            return null;
        }

        @Override
        public void add(int index, String element) {
add(0, String.valueOf(questionEditText));
add(1,String.valueOf(correctAnswerEditText));
add(2, String.valueOf(incorrectAnswerOneEditText));
add(3, String.valueOf(incorrectAnswerTwoEditText));
add(4, String.valueOf(incorrectAnswerThreeEditText));
        }

        @Override
        public String remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator<String> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<String> listIterator(int index) {
            return null;
        }

        @NonNull
        @Override
        public List<String> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    public List<String> shuffleAnswers(){
        Random rgen = new Random();
        for(int i=1; i<list.size(); i++) {
            int randomPosition = rgen.nextInt(list.size());
            int temp = list.indexOf(i);
            list.indexOf(i) = list.indexOf(randomPosition);
            list.indexOf(randomPosition) = temp;
        }
        return list;

        }
    }


//        public static int[] RandomizeArray(int[] array){	Random rgen = new Random();  // Random number generator	  for (int i=0; i<array.length; i++) {	    int randomPosition = rgen.nextInt(array.length);	    int temp = array[i];	    array[i] = array[randomPosition];	    array[randomPosition] = temp;	}  return array;	}
//    }


}
