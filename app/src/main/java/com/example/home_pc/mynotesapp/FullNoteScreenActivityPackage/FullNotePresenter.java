package com.example.home_pc.mynotesapp.FullNoteScreenActivityPackage;

import com.example.home_pc.mynotesapp.Data.RealmDB;
import com.example.home_pc.mynotesapp.Note;

//import static com.example.home_pc.mynotesapp.MainActivityPackage.MainActivity.realm;

public class FullNotePresenter {

    FullNoteScreenInterface fullNoteScreenInterface;
    RealmDB realmDB;

    public FullNotePresenter(FullNoteScreenInterface fullNoteScreenInterface){
        this.fullNoteScreenInterface = fullNoteScreenInterface;
        realmDB = new RealmDB();
    }

    public void getNote(int position) {
        Note currentNote = realmDB.showNoteFullScreen(position);
        fullNoteScreenInterface.getNote(currentNote);
    }
}
