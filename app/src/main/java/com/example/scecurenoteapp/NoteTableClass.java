package com.example.scecurenoteapp;

import android.provider.BaseColumns;

public class NoteTableClass implements BaseColumns {
    public static final String NOTETABLE="note_table";
    public static final String DESCRIPTIONCOLUMN="desc_column";
    public static final String TITLECOLUMN="title_column";

    public static final String SQL_CREATE_TABLE="CREATE TABLE " +NOTETABLE+ " ( "+
            _ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            TITLECOLUMN +" TEXT NOT NULL " +", "+
            DESCRIPTIONCOLUMN +" TEXT NOT NULL " +" );";



}
