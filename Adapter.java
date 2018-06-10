package com.yasaman.todolist;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeoutException;

public class Adapter extends RecyclerView.Adapter<Adapter.TodoViewHolder> {
    public Date date;
    private static final String TAG = "Adapter";
    public ArrayList<Todo> todos;
    public int id=0;
    LayoutInflater inflater;

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView desTextView;
        public TextView dateTextView;

        public TodoViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.title);
            desTextView = (TextView) itemView.findViewById(R.id.des);
            dateTextView = (TextView)itemView.findViewById(R.id.saving_date);
        }
    }

    public Adapter(Context context) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(ArrayList<Todo> privateArray) {
        todos = privateArray;
        Log.d("TAG", "this is are datas:" + todos);
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_view, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TodoViewHolder holder, final int position) {
        final Todo todo = todos.get(position);
        holder.titleTextView.setText(todo.title);
        holder.desTextView.setText(todo.description);
        date = todo.getCurrentDate(GregorianCalendar.getInstance().getTime());
        holder.dateTextView.setText(date.toString());
        Log.d(TAG , "id e todo" + todo.getId());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).create();

                alertDialog.setTitle("مطمئن هستی؟");
                alertDialog.setMessage("آیا برای پاک کردن این تودو مطمئن هستی؟");
                alertDialog.setButton(alertDialog.BUTTON_NEGATIVE, "خیر", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.cancel();
                    }
                });
                alertDialog.setButton(alertDialog.BUTTON_POSITIVE, "بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        which = holder.getAdapterPosition();
                        todos.remove(which);
                        notifyItemRemoved(which);
                        notifyDataSetChanged();
                    }
                });
                alertDialog.show();
                return true;
            }
        });
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext() , NewTask.class);
                    intent.putExtra("title" ,holder.titleTextView.getText().toString());
                    intent.putExtra("des" ,holder.desTextView.getText().toString());
                    intent.putExtra("id" , todo.getId());
                    intent.putExtra("itemCount" , getItemCount());
                    Log.d(TAG, "id" + todo.getId());
                    v.getContext().startActivity(intent);
                }
            });

    }

    @Override
    public int getItemCount() {
        return todos.size();
    }
}
