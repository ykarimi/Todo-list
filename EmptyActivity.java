package com.yasaman.todolist;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.constraint.solver.widgets.ConstraintHorizontalLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.concurrent.TimeoutException;

public class EmptyActivity extends AppCompatActivity{
    public TextView emptyTextView;
    public Button addNoteButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_activity);
//        Configuration configuration = getResources().getConfiguration();
//        configuration.setLayoutDirection( , View.LAYOUT_DIRECTION_RTL);
        emptyTextView = (TextView)findViewById(R.id.empty_text_view);
        emptyTextView.setText("هنوز تودویی موجود نیست! \n برای ساختن تودو \n روی دکمه‌ی پایین کلیک کن.");
        addNoteButton = (Button)findViewById(R.id.add_note_button);
        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmptyActivity.this , NewTask.class);
                startActivity(intent);
            }
        });



    }




}
