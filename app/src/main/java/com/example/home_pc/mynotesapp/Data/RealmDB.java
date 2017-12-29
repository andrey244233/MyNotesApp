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

    public void addNote(Context context) {
//        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Note note = realm.createObject(Note.class);
                note.setText("text");
                note.setTimeCreated("333333");
                note.setNotification(true);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.v("tag", "on success");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {

                Log.v("tag", "on error" + error.getCause());
            }
        });
        realm.commitTransaction();
    }

    public void deleteNote() {

    }

    public void updateeNote() {

    }

}
