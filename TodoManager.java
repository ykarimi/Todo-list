package com.yasaman.todolist;

import android.util.Log;
import android.webkit.GeolocationPermissions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class TodoManager {
    private static final String TAG = "TodoManager";
    ArrayList<Todo> data = new ArrayList<>();
    int lastTodoId = data.size();

    static TodoManager instance;

    static TodoManager getInstance() {
        if (instance == null)
            instance = new TodoManager();
        return instance;
    }

    public void addTodo(String title, String des ,int id) {
        Log.d(TAG , "lastTodoid:  " + lastTodoId);
        Date currentTime = GregorianCalendar.getInstance().getTime();
        Log.d(TAG , "current time: " + currentTime );
        Todo todo = new Todo(title, des, lastTodoId , currentTime);
        lastTodoId++;
        data.add(todo);
        int i = data.size();
        Log.d(TAG, "counter : " + i);
    }
    public void changeTodo(Todo todo){
        Log.d(TAG  , "id jadid: " +todo.getId());
        Date currentTime = GregorianCalendar.getInstance().getTime();
        todo.setCurrentDate(currentTime);
        Log.d(TAG , "current time: " + currentTime);
        data.set(todo.getId(),todo);
        Log.d(TAG , "ChangeTodo ejra shod");
    }

    public ArrayList<Todo> getTodos() {
        return data;
    }

}
