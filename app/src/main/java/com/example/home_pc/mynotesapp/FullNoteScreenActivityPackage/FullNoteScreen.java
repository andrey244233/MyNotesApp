package com.example.home_pc.mynotesapp.FullNoteScreenActivityPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;

import com.example.home_pc.mynotesapp.Note;
import com.example.home_pc.mynotesapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;


import static com.example.home_pc.mynotesapp.MainActivityPackage.MainActivityPresenter.POSITION;

public class FullNoteScreen extends AppCompatActivity implements FullNoteScreenInterface {

    @BindView(R.id.tv_text_full)
    TextView tvTextFull;
    @BindView(R.id.tv_time_full)
    TextView tvTimeFull;
    @BindView(R.id.switch_notif_full)
    Switch switchFull;
    Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_note_screen);
        ButterKnife.bind(this);

        FullNotePresenter fullNotePresenter = new FullNotePresenter(this);
        int position = getIntent().getIntExtra(POSITION, 0);
        fullNotePresenter.getNote(position);
        initViews();
    }

    @Override
    public void getNote(Note note) {
        this.note = note;
    }

    @Override
    public void initViews() {
        tvTextFull.setText(note.getText());
        tvTimeFull.setText(note.getTimeCreated());
        switchFull.setChecked(note.getNotification());
    }
}
