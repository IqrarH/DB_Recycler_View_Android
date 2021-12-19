package com.example.db_recycler_view_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.MyViewHolder> {
    List<StudentModel> studentsList;

    public myRecyclerViewAdapter(List<StudentModel> studentsList){
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.data = studentsList.get(position);
        holder.textViewStudentName.setText(holder.data.getName());
        holder.textViewAge.setText(holder.data.getAge());
        holder.textViewActive.setText(holder.data.isActive()? "Active" : "Inactive");
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textViewStudentName;
        TextView textViewAge;
        TextView textViewActive;
        StudentModel data;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            textViewStudentName = itemView.findViewById(R.id.textViewStudentName);
            textViewAge = itemView.findViewById(R.id.textViewAge);
            textViewActive = itemView.findViewById(R.id.textViewActive);
        }
    }

}
