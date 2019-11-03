package com.example.scecurenoteapp;

import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;

public class noteHolder   {
    String description;
    String title;
    private int id;

    public noteHolder(String description, String title, int id){
        this.description = description;
        this.title=title;
        this.id=id;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {this.description = description;}

    public String getTitle(){return  title;}
    public void setTitle(String title){this.title=title ;}
    public void setId(int id){this.id=id;
    }

    public int getId() {
        return id;
    }
}

