package com.example.home_pc.mynotesapp.MainActivityPackage;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.home_pc.mynotesapp.Data.RealmDB;
import com.example.home_pc.mynotesapp.Note;
import com.example.home_pc.mynotesapp.NoteAdapterPackage.NoteAdapter;
import com.example.home_pc.mynotesapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


public class MainActivity extends AppCompatActivity implements NoteAdapter.ItemClickCallBack, MainActivityInterface {

    @BindView(R.id.cat_recyclre_view)
    RecyclerView catRecyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private MainActivityPresenter mainActivityPresenter;
   // public static Realm realm;
    ArrayList<Note> notes = new ArrayList<>();
    ArrayList<Note> list;
    RealmDB realmDB;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.splashScreenTheme);
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        realmDB = new RealmDB();
        realm = Realm.getDefaultInstance();


      //  getDammyData();

        mainActivityPresenter = new MainActivityPresenter(this);
       // mainActivityPresenter.showAllNotes();
        notes = new ArrayList(realm.where(Note.class).findAll());
        Log.v("tag", "size = " + notes.size());
        NoteAdapter noteAdapter = new NoteAdapter(this, notes);
        noteAdapter.setItemClickCallBack(this);
        catRecyclerView.setAdapter(noteAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        catRecyclerView.setLayoutManager(linearLayoutManager);
        makeFloatActionButtonHideAndShow();
        fab.setOnClickListener(fabOnClickListener);
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

    private ArrayList<Note> getDammyData() {
        ArrayList<Note> notes = new ArrayList<>();
        realm.beginTransaction();
        Note note = new Note("Hallo worlds", true, "33.21.43");
        realm.copyToRealmOrUpdate(note);
        realm.copyToRealmOrUpdate(new Note("Hallo worlds", true, "33.21.43"));
        // realm.copyToRealm(new Note("Hallo worlds", true, "33.21.43"));
        // realm.copyToRealm(new Note("Hallo worlds", true, "33.21.43"));
        realm.commitTransaction();
        return notes;
    }

//    Cat defaultCat = new Cat();
//    long autoIncrementId;
//            if(realm.where(Cat.class).count() > 0) {
//        autoIncrementId = realm.where(Cat.class).max(CatFields.ID.getField()).longValue();
//    } else {
//        autoIncrementId= 0;
//    }
//            defaultCat.setId(++autoIncrementId);


    @Override
    public void onItemClick(int position, View v) {
        switch (v.getId()) {
            case R.id.tvText:
                mainActivityPresenter.openFullNote(this, position);
                // Toast.makeText(this, "position of textview" + position, Toast.LENGTH_SHORT).show();
                break;
            case R.id.switchNotification:
                mainActivityPresenter.openNotificationActivity(this);
                Toast.makeText(this, "position of notification" + position, Toast.LENGTH_SHORT).show();
                break;

        }
    }

    View.OnClickListener fabOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.v("tag", "fab on click");
            getDammyData();
            mainActivityPresenter.addNewNote(MainActivity.this);
           // getDammyData();
        }
    };


}
