package com.yasaman.todolist;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.constraint.solver.widgets.ConstraintHorizontalLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public TextView emptyTextView;
    public Button addNoteButton;
    Adapter todoAdapter;
    public Button newTodoButton;
    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        findViews();
        Typeface typeface = Typeface.createFromAsset(getAssets() , "fonts/iran-sans-fonts.ttf");
        newTodoButton.setTypeface(typeface);
        emptyTextView.setTypeface(typeface);
        addNoteButton.setTypeface(typeface);
        emptyTextView.setText("هنوز تودویی موجود نیست! \n برای ساختن تودو \n روی دکمه‌ی پایین کلیک کن.");

        newTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewTask.class);
                startActivity(intent);
            }
        });
        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewTask.class);
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
        todoAdapter = new Adapter(MainActivity.this);
        todoAdapter.notifyDataSetChanged();
        todoAdapter.setData(TodoManager.getInstance().getTodos());
        recyclerView.setAdapter(todoAdapter);
        if (TodoManager.getInstance().getTodos() == null || todoAdapter.getItemCount() == 0) {
            emptyTextView.setVisibility(View.VISIBLE);
            addNoteButton.setVisibility(View.VISIBLE);
        } else {
            Log.d("TAG", "after if:  " + TodoManager.getInstance().getTodos());
            recyclerView.setVisibility(View.VISIBLE);
            newTodoButton.setVisibility(View.VISIBLE);
            emptyTextView.setVisibility(View.INVISIBLE);
            addNoteButton.setVisibility(View.INVISIBLE);

        }
    }

    public void findViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        newTodoButton = (Button) findViewById(R.id.new_todo);
        emptyTextView = (TextView) findViewById(R.id.empty_text_view);
        addNoteButton = (Button) findViewById(R.id.new_todo_empty_activity);

    }


}
