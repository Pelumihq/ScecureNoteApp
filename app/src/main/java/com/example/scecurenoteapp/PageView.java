package com.example.scecurenoteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import static android.provider.BaseColumns._ID;
import static com.example.scecurenoteapp.MainActivity.noteList;
import static com.example.scecurenoteapp.NoteTableClass.DESCRIPTIONCOLUMN;
import static com.example.scecurenoteapp.NoteTableClass.NOTETABLE;
import static com.example.scecurenoteapp.NoteTableClass.TITLECOLUMN;

public class PageView extends AppCompatActivity {
    EditText enterText;
    EditText enterTitle;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_view);
        enterText=findViewById(R.id.enterTextId);
        enterTitle=findViewById(R.id.enterTitleId);
         position= getIntent().getIntExtra("position",-1);
         Log.d("pelumiDebugg","Position in noteview is "+position);
        if(position==-1){
            return;
        }

        noteHolder note= noteList.get(position);
        String title=note.getTitle();
        String description=note.getDescription();



        enterTitle.setText(title);
        enterText.setText(description);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
                if(id==R.id.menu_save);
                saveNote();
                finish();
        return super.onOptionsItemSelected(item);
    }
    public void saveNote(){
        if(position==-1){
            createNewNote();
        }else{
            updateNote();
        }
//        String title=enterTitle.getText().toString();
//        String  text=enterText.getText().toString();
//        noteHolder note= new noteHolder(title,text);
//        noteList.add(note);

    }
    public  void createNewNote(){
        NoteOpenHandler noteOpenHandler=new NoteOpenHandler(this);
        SQLiteDatabase db=noteOpenHandler.getWritableDatabase();
        String title=enterTitle.getText().toString();
        String  text=enterText.getText().toString();

        ContentValues contentValues=new ContentValues();
        contentValues.put(TITLECOLUMN,title);
        contentValues.put(DESCRIPTIONCOLUMN,text);
        db.insert(NOTETABLE,null,contentValues);

    }

    public void updateNote(){
        Log.d("pelumiDebugg","enterred updatenote");
        NoteOpenHandler noteOpenHandler=new NoteOpenHandler(this);
        SQLiteDatabase db=noteOpenHandler.getWritableDatabase();
        String title=enterTitle.getText().toString();
        String  text=enterText.getText().toString();
        int id=noteList.get(position).getId();
        Log.d("pelumiDebugg","The id is "+ id);
        ContentValues contentValues=new ContentValues();
        contentValues.put(TITLECOLUMN,title);
        contentValues.put(DESCRIPTIONCOLUMN,text);

        String where=_ID +" = ?" ;
        String[] whereArgs={String.valueOf(id)};
        int val;
        val = db.update(NOTETABLE,contentValues,where,whereArgs);
        Log.d("pelumDebugg",val+" boov");




    }
}
