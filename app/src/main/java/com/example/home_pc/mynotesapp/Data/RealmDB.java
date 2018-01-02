package com.example.home_pc.mynotesapp.Data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.home_pc.mynotesapp.Note;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;

//import static com.example.home_pc.mynotesapp.MainActivityPackage.MainActivity.realm;

public class RealmDB {

    Realm realm = Realm.getDefaultInstance();


    @NonNull
    public ArrayList<Note> showAllNotes() {
        return new ArrayList(realm.where(Note.class).findAll());
    }

    public Note showNoteFullScreen(int position) {
        Note currentNote = realm
                .where(Note.class)
                .equalTo("id", position)
                .findFirst();
        return currentNote;
    }

    public void addNote(final int id, final String text, final String time) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Note note = realm.createObject(Note.class);
                note.setText(text);
                note.setTimeCreated(time);
                note.setNotification(false);
                note.setId(id);
            }
        });

    }


    public void deleteNote() {

    }

    public void updateeNote() {

    }

}
