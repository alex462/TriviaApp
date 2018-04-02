package com.example.alexandrareinhart.triviaapp;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.DialogTitle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class ScoreDialogFragment extends android.support.v4.app.DialogFragment {

    private Button okayButton;
    private DialogTitle dialogTitle;
    private TextView dialogMessage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        ButterKnife.bind(this, getView());

        builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);

//        return builder.create();
    }

    @Override
    OnClick(R.id.okayButton)
        Protected
}
