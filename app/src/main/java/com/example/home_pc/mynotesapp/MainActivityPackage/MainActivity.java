package com.example.home_pc.mynotesapp.MainActivityPackage;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import java.util.Date;

import com.example.home_pc.mynotesapp.AddNewNoteActivity;
import com.example.home_pc.mynotesapp.Data.RealmDB;
import com.example.home_pc.mynotesapp.Note;
import com.example.home_pc.mynotesapp.NoteAdapterPackage.NoteAdapter;
import com.example.home_pc.mynotesapp.NotificationActivity;
import com.example.home_pc.mynotesapp.R;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.home_pc.mynotesapp.AddNewNoteActivity.NOTE_TEXT;
import static com.example.home_pc.mynotesapp.NotificationActivity.DATA;

public class MainActivity extends AppCompatActivity implements NoteAdapter.ItemClickCallBack, MainActivityInterface {

    @BindView(R.id.cat_recyclre_view)
    RecyclerView catRecyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    MainActivityPresenter mainActivityPresenter;
    ArrayList<Note> notes = new ArrayList<>();
    NoteAdapter noteAdapter;
    RealmDB realmDB;
    private int ID;
    public static final int ADD_NEW_NOTE_REQUEST_CODE = 100;
    public static final int SET_NOTIFICATION_REQUEST_CODE = 200;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.splashScreenTheme);
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        realmDB = new RealmDB();
        mainActivityPresenter = new MainActivityPresenter(this);
        mainActivityPresenter.showAllNotes();
        Log.v("tag", "size = " + notes.size());

        noteAdapter = new NoteAdapter(this, notes);
        noteAdapter.setItemClickCallBack(this);
        catRecyclerView.setAdapter(noteAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        catRecyclerView.setLayoutManager(linearLayoutManager);
        makeFloatActionButtonHideAndShow();
        fab.setOnClickListener(fabOnClickListener);
        ID = notes.size();

    }

    @Override
    public void makeFloatActionButtonHideAndShow() {
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

    @Override
    public void showAllNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @Override
    public void onItemClick(int position, View v) {
        switch (v.getId()) {
            case R.id.tvText:
                mainActivityPresenter.openFullNote(this, position);
                // Toast.makeText(this, "position of textview" + position, Toast.LENGTH_SHORT).show();
                break;
            case R.id.switchNotification:
                //mainActivityPresenter.openNotificationActivity(this);
                Switch sw = (Switch) v;
                if(!sw.isChecked()) {
                    Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                    startActivityForResult(intent, SET_NOTIFICATION_REQUEST_CODE);
                    Toast.makeText(this, "position of notification" + position, Toast.LENGTH_SHORT).show();
                }else{
                    sw.setChecked(false);
                }
                break;
        }
    }

    View.OnClickListener fabOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, AddNewNoteActivity.class);
            startActivityForResult(intent, ADD_NEW_NOTE_REQUEST_CODE);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK & requestCode == ADD_NEW_NOTE_REQUEST_CODE) {
            text = data.getStringExtra(NOTE_TEXT);
            Log.v("tag", "text = " + text);
            mainActivityPresenter.addNewNote(ID++, text);
            mainActivityPresenter.showAllNotes();
            noteAdapter.setData(notes);
        }
        if (resultCode == RESULT_OK & requestCode == SET_NOTIFICATION_REQUEST_CODE) {
            Date date = (Date) data.getSerializableExtra(DATA);
            Log.v("tag", "data = " + date.toString());
            Log.v("tag", "on activity result");
        }
    }
    }

