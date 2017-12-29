package com.example.home_pc.mynotesapp.MainActivityPackage;

import android.content.Context;
import android.content.Intent;

import com.example.home_pc.mynotesapp.Data.RealmDB;
import com.example.home_pc.mynotesapp.FullNoteScreenActivityPackage.FullNoteScreen;
import com.example.home_pc.mynotesapp.Note;

import java.util.ArrayList;

public class MainActivityPresenter {

    public static String POSITION = "position";
    private MainActivityInterface mainActivityInterface;
    private RealmDB realmDB;

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

    public void addNewNote(Context context){
       realmDB.addNote(context);
    }
}
