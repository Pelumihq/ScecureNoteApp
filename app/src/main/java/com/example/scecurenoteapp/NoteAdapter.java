package com.example.scecurenoteapp;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends  RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    Context context;
    List<noteHolder> noteList;
    public NoteAdapter(Context context, List<noteHolder> noteList){
        this.context=context;
        this.noteList=noteList;
    }
    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.note_item,parent,false);

        return new NoteViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        noteHolder note=noteList.get(position);
        holder.titleText.setText(note.getTitle());
        holder.descriptionText.setText(note.getDescription());
        holder.position=position;
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class  NoteViewHolder extends RecyclerView.ViewHolder{

        TextView  descriptionText;
        TextView titleText;
        int position;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            descriptionText=itemView.findViewById(R.id.note_text_description);
            titleText=itemView.findViewById(R.id.note_text_title);
            itemView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent= new Intent(context,PageView.class);
                            Log.d("pelumiDebugg","Position is "+ position);
                            intent.putExtra("position",position);
                            context.startActivity(intent);
                        }
                    }
            );
        }
    }
}