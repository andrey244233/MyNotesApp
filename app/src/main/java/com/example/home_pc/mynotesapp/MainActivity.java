package com.example.home_pc.mynotesapp;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cat_recyclre_view)
    RecyclerView catRecyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.splashScreenTheme);
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        NoteAdapter noteAdapter = new NoteAdapter(this, getDammyData());
        catRecyclerView.setAdapter(noteAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        catRecyclerView.setLayoutManager(linearLayoutManager);

        makeFloatActionButonHideAndShow();


    }

    private void makeFloatActionButonHideAndShow() {
        catRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy < 0) {
                    fab.show();
                } else if (dy > 0) {
                    fab.hide();
                }
            }
        });
    }

    private ArrayList<Note> getDammyData() {
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note("Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds ", true));
        notes.add(new Note("Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds ", true));
        notes.add(new Note("Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds ", true));
        notes.add(new Note("Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds Hallo worlds ", true));
        notes.add(new Note("Hallo worlds", true));
        notes.add(new Note("Hallo worlds", true));
        notes.add(new Note("Hallo worlds", true));
        notes.add(new Note("Hallo worlds", true));
        notes.add(new Note("Hallo worlds", true));
        notes.add(new Note("Hallo worlds", true));
        notes.add(new Note("Hallo worlds", true));
        notes.add(new Note("Hallo worlds", true));
        notes.add(new Note("Hallo worlds", true));
        notes.add(new Note("Hallo worlds", true));
        notes.add(new Note("Hallo worlds", true));
        notes.add(new Note("Hallo worlds", true));
        notes.add(new Note("Hallo worlds", true));
        return notes;
    }


}
