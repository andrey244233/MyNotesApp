package com.example.home_pc.mynotesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNewNoteActivity extends AppCompatActivity {

    @BindView(R.id.ed_note)
    EditText etNote;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    public static final String NOTE_TEXT = "note text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_note);
        ButterKnife.bind(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnResultToActivity();
            }
        });
    }

    public void returnResultToActivity() {
        Intent intent = new Intent();
        intent.putExtra(NOTE_TEXT, etNote.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }


}
