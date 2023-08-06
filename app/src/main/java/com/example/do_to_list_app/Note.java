package com.example.do_to_list_app;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity (tableName = "my_notes")
public class Note {
    @PrimaryKey(autoGenerate=true)
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String disp;

    public Note(String title, String disp) {
        this.title = title;
        this.disp = disp;
    }

    public Note() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisp() {
        return disp;
    }

    public void setDisp(String disp) {
        this.disp = disp;
    }
}
