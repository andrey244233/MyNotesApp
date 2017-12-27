package com.example.home_pc.mynotesapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private Context mContext;
    private ArrayList<Note> listNotes;
    private TextView tvText;
    private Switch switchNotification;

    public NoteAdapter(Context context, ArrayList<Note> notes) {
        mContext = context;
        listNotes = notes;
    }


    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {

        Note currentNote = listNotes.get(position);
        tvText.setText(currentNote.getText());
        boolean notify = currentNote.getNotification();
        switchNotification.setChecked(notify);
    }

    @Override
    public int getItemCount() {
        return listNotes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        public NoteViewHolder(View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tvText);
            switchNotification = itemView.findViewById(R.id.switchNotification);

        }
    }
}
