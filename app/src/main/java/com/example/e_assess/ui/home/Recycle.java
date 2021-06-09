package com.example.e_assess.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_assess.R;
import com.example.e_assess.chooseExam;
import com.example.e_assess.ui.home.Recycle;
import com.example.e_assess.ui.home.Guide;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class Recycle extends RecyclerView.Adapter<com.example.e_assess.ui.home.Recycle.MyViewHolder> {
    ArrayList<Guide> mlist;
    Context context;

    public Recycle(Context context, ArrayList<Guide> mlist){
        this.mlist = mlist;
        this.context= context;
    }

    public Recycle(Context context) {
        this.context = context;
    }



    @NonNull
    @Override
    public Recycle.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_view,parent,false);
        return new Recycle.MyViewHolder(v);
    }
    //public com.example.e_assess.ui.home.Recyle.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    //View v = LayoutInflater.from(context).inflate(R.layout.card_view,parent,false);
    //return new com.example.e_assess.ui.home.Guide.MyViewHolder(v);
    //}
    public void onBindViewHolder(@NonNull Recycle.MyViewHolder holder, int position) {
     final   Guide guide = mlist.get(position);
        holder.GroupNo.setText(guide.getGroupNo());
        holder.TopicName.setText(guide.getTopicName());
        holder.asignmarksicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   Intent intent = new Intent(context, chooseExam.class);
                   intent.putExtra("stud1name",guide.getStudent1());
                   intent.putExtra("stud2name",guide.getStudent2());
                   intent.putExtra("stud3name",guide.getStudent3());
                   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView GroupNo,TopicName;
        ImageView asignmarksicon ;
        public MyViewHolder(@Nullable View itemView){
            super(itemView);
            GroupNo=itemView.findViewById(R.id.grpno);
            TopicName = itemView.findViewById(R.id.top);
            asignmarksicon = itemView.findViewById(R.id.assignmarksicon);
        }
    }

}