package com.yasaman.todolist;

import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class NewTask extends AppCompatActivity{
    private static final String TAG = "NewTask";
    public TextView newTitle;
    public TextView newDes;
    public Button saveButton;
    public Button cancelButton;
    public EditText title;
    public EditText description;
    public Button attachButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);
      //  InputMethodManager imm = (InputMethodManager)this.getSystemService(Service.INPUT_METHOD_SERVICE);
        newTitle = (TextView) findViewById(R.id.new_title);
        newDes = (TextView) findViewById(R.id.new_description);
        title = (EditText)findViewById(R.id.title_edit_text);
        description = (EditText)findViewById(R.id.des_edit_text);
        saveButton = (Button)findViewById(R.id.save_button);
        cancelButton = (Button)findViewById(R.id.cancel_button);
        attachButton = (Button) findViewById(R.id.attachment_button);
        newTitle.setText("عنوان: ");
        newDes.setText("توضیح: ");
        Typeface typeface = Typeface.createFromAsset(getAssets() , "fonts/iran-sans-fonts.ttf");
        newTitle.setTypeface(typeface);
        newDes.setTypeface(typeface);
        saveButton.setTypeface(typeface);
        cancelButton.setTypeface(typeface);
        final String editedTitle = getIntent().getStringExtra("title");
        final String editedDes = getIntent().getStringExtra("des");
        title.setText(editedTitle);
        description.setText(editedDes);
        title.setTypeface(typeface);
        description.setTypeface(typeface);
        final int i = getIntent().getIntExtra("id" , 0 );
        Log.d(TAG, "onCreate: i = " + i);
        final int count = getIntent().getIntExtra("itemCount" , 0 );
        Log.d(TAG , "getItemCounts:" + count);
        title.setMaxLines(1);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (title.getText().toString().isEmpty() && !(description.getText().toString().isEmpty())) {
                    Log.d(TAG, "while ejra shod: ");
                    final AlertDialog alertDialog = new AlertDialog.Builder(NewTask.this).create();
                    alertDialog.setTitle("اخطار");
                    alertDialog.setMessage("عنوان را خالی نگذارید");
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "باشه ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            alertDialog.cancel();
                        }
                    });
                    alertDialog.show();
                }

            else {
                    if (editedDes != null || editedTitle != null) {
                        Todo todo;
                        Date currentDate = GregorianCalendar.getInstance().getTime();
                        todo = new Todo(title.getText().toString(), description.getText().toString(), i ,currentDate);
                        Log.d(TAG , "current time : " + currentDate);
                        Log.d(TAG, "id :  " + i);
                        TodoManager.getInstance().changeTodo(todo);
                    } else {
                        TodoManager.getInstance().addTodo(title.getText().toString(), description.getText().toString(), count);
                    }
                    TodoManager.getInstance().getTodos();
                    finish();
                }
        }
                                      });


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        attachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }

}
