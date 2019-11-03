package com.example.scecurenoteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import static android.provider.BaseColumns._ID;
import static com.example.scecurenoteapp.NoteTableClass.DESCRIPTIONCOLUMN;
import static com.example.scecurenoteapp.NoteTableClass.NOTETABLE;
import static com.example.scecurenoteapp.NoteTableClass.TITLECOLUMN;

public class MainActivity extends AppCompatActivity {
      RecyclerView EditRecyclerView;
      ImageView newButtonDesign;
      static List<noteHolder> noteList=new ArrayList<>();
      private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditRecyclerView =findViewById(R.id.recyclerViewEdit);
        newButtonDesign=findViewById(R.id.newNoteButton);
        NoteOpenHandler noteOpenHandler=new NoteOpenHandler(this);
        db = noteOpenHandler.getReadableDatabase();
        newButtonDesign.setOnClickListener(
                new ImageView.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainActivity.this, PageView.class);
                        startActivity(intent);
                    }
                }
        );


    }

    @Override
    protected void onStart() {
        super.onStart();
        noteList.clear();
        EditRecyclerView.setLayoutManager(new LinearLayoutManager(this));
       readNoteItem();
    }

    public void readNoteItem(){
        String[] columnNames={TITLECOLUMN,DESCRIPTIONCOLUMN,_ID};
        Cursor cursor=db.query(NOTETABLE,null,null,null,null,null,null);
        int titlePosition=cursor.getColumnIndex(TITLECOLUMN);
        int descriptionPosition=cursor.getColumnIndex(DESCRIPTIONCOLUMN);
        int idPosition=cursor.getColumnIndex(_ID);
        while(cursor.moveToNext()){
            String title=cursor.getString(titlePosition);
            String description=cursor.getString(descriptionPosition);
            int id=cursor.getInt(idPosition);
            Log.d("pelumiDebugg"," The id at readNoteItem is "+ id);
            noteHolder note=new noteHolder(title,description,id);
            noteList.add(note);
        }
        EditRecyclerView.setHasFixedSize(true);
        NoteAdapter noteadapter= new NoteAdapter(this,noteList);
        EditRecyclerView.setAdapter(noteadapter);
    }
}
