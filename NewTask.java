package com.yasaman.todolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NewTask extends AppCompatActivity{
    public TextView newTitle;
    public TextView newDes;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);
        newTitle = (TextView) findViewById(R.id.new_title);
        newDes = (TextView) findViewById(R.id.new_description);
        newTitle.setText("عنوان: ");
        newDes.setText("توضیح: ");

    }
}
