package com.example.home_pc.mynotesapp.MainActivityPackage;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.home_pc.mynotesapp.AddNewNoteActivity;
import com.example.home_pc.mynotesapp.Data.RealmDB;
import com.example.home_pc.mynotesapp.FullNoteScreenActivityPackage.FullNoteScreen;
import com.example.home_pc.mynotesapp.Model;
import com.example.home_pc.mynotesapp.Note;

import java.util.ArrayList;


import static android.support.v4.app.ActivityCompat.startActivityForResult;
import static com.example.home_pc.mynotesapp.AddNewNoteActivity.NOTE_TEXT;
import static com.example.home_pc.mynotesapp.MainActivityPackage.MainActivity.ADD_NEW_NOTE_REQUEST_CODE;

public class MainActivityPresenter {

    public static String POSITION = "position";
    private MainActivityInterface mainActivityInterface;
    private RealmDB realmDB;
    private MainActivity mainActivity;
    private Model model = new Model();

    public MainActivityPresenter(MainActivityInterface mainActivityInterface){
        this.mainActivityInterface = mainActivityInterface;
        realmDB = new RealmDB();
    }

    public void openFullNote(Context context, int position) {
        Intent intent = new Intent(context, FullNoteScreen.class);
        intent.putExtra(POSITION, position);
        context.startActivity(intent);
    }

    public void openNotificationActivity(Context context) {
    }

    public void showAllNotes() {
        ArrayList<Note> notes = realmDB.showAllNotes();
        mainActivityInterface.showAllNotes(notes);
    }

    public void addNewNote(int ID, String text){
        String data = model.getTime();
       realmDB.addNote(ID, text, data);
    }



}
