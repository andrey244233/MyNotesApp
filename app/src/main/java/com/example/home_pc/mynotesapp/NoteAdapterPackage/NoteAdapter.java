package com.example.home_pc.mynotesapp.NoteAdapterPackage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.home_pc.mynotesapp.Note;
import com.example.home_pc.mynotesapp.R;

import java.util.ArrayList;

import io.realm.RealmResults;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private Context mContext;
    private ArrayList<Note> listNotes;
    private TextView tvText, tvTime;
    private Switch switchNotification;
    private ItemClickCallBack itemClickCallBack;
    private boolean notify;

    public NoteAdapter(Context context, ArrayList<Note> notes) {
        mContext = context;
        listNotes  = notes;
    }

    public interface ItemClickCallBack {
        void onItemClick(int position, View v);
    }

    public void setItemClickCallBack(ItemClickCallBack itemClickCallBack) {
        this.itemClickCallBack = itemClickCallBack;
    }


    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Note currentNote = listNotes.get(position);
        tvTime.setText(currentNote.getTimeCreated());
        tvText.setText(currentNote.getText());
         notify = currentNote.getNotification();
        switchNotification.setChecked(notify);
    }

    @Override
    public int getItemCount() {
        return listNotes.size();
    }

    public void setData(ArrayList<Note> listNotes) {
        this.listNotes = listNotes;
        notifyDataSetChanged();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public NoteViewHolder(View itemView) {
            super(itemView);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvText = itemView.findViewById(R.id.tvText);
            tvText.setOnClickListener(this);
            switchNotification = itemView.findViewById(R.id.switchNotification);
            switchNotification.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tvText:
                    itemClickCallBack.onItemClick(getAdapterPosition(), v);
                    break;
                case R.id.switchNotification:
                    itemClickCallBack.onItemClick(getAdapterPosition(), v);
                    break;
            }
        }
    }
}
