package com.example.e_assess.ui.admingroup;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_assess.R;
import com.example.e_assess.ui.HomeAdmin.MyAdapter;
import com.example.e_assess.ui.HomeAdmin.model;


import android.content.Context;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MyadapterGroupAdmin extends RecyclerView.Adapter<MyadapterGroupAdmin.MyViewHolder>  {
    ArrayList<moduleGroups> mlist;
    Context context;

    public MyadapterGroupAdmin( Context context,ArrayList<moduleGroups> mlist){
        this.mlist=mlist;
        this.context =context;

    }

    public MyadapterGroupAdmin(Context context) {
        this.context = context;
    }
    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.singlerowgroupclas, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        moduleGroups model= mlist.get(position);
        holder.stud1.setText(model.getStudent1());
        holder.stud2.setText(model.getStudent2());
        holder.stud3.setText(model.getStudent3());
        holder.topicname.setText(model.getTopicName());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView stud1,stud2,stud3,topicname;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            stud1 = itemView.findViewById(R.id.txtstud1);
            stud2 = itemView.findViewById(R.id.txtstud2);
            stud3 = itemView.findViewById(R.id.txtstud3);
            topicname = itemView.findViewById(R.id.txttop);

        }
    }
}