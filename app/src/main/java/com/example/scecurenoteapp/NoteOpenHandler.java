package com.example.scecurenoteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.scecurenoteapp.NoteTableClass.SQL_CREATE_TABLE;

public class NoteOpenHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="NOTEKEEPER.db";
    public static final int  DATABASE_VERSION=1;

    public NoteOpenHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
