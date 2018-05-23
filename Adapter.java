package com.yasaman.todolist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.TodoViewHolder>{
    public ArrayList<Todo>todos;

    LayoutInflater inflater;
    public class TodoViewHolder extends RecyclerView.ViewHolder{
        public TextView titleTextView;
        public TextView desTextView;

        public TodoViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView)itemView.findViewById(R.id.title);
            desTextView = (TextView) itemView.findViewById(R.id.des);
        }
    }
    public Adapter(Context context){
     inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    private void setData(ArrayList<Todo> privateArray){
        todos=privateArray;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_view , parent , false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TodoViewHolder holder,final int position) {
        Todo todo = todos.get(position);
        holder.titleTextView.setText(todo.title);
        holder.desTextView.setText(todo.description);
    }

    @Override
    public int getItemCount() {
        if(todos == null)
        return 0;
        return todos.size();
    }

}
