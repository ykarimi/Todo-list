package com.yasaman.todolist;

import java.util.Date;

public class Todo {
    String title;
    String description;
    int id=0;
    Date currentDate;

    public Todo(String title, String description , int id, Date currentDate) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.currentDate =currentDate;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setCurrentDate(Date currentDate){
        this.currentDate = currentDate;
    }
    public Date getCurrentDate(Date currentDate){
        return currentDate;
    }
}
