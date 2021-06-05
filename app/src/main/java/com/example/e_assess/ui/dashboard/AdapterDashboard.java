package com.example.e_assess.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_assess.R;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class AdapterDashboard extends RecyclerView.Adapter<AdapterDashboard.MyViewHolder> {
  ArrayList<ModelDashboard> mlist;
  Context context;

  public AdapterDashboard(Context context,ArrayList<ModelDashboard> mlist){
      this.mlist = mlist;
      this.context= context;
  }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
  ModelDashboard model = mlist.get(position);
  holder.Student1.setText(model.getStudent1());
  holder.Student2.setText(model.getStudent2());
  holder.Student3.setText(model.getStudent3());
  holder.TopicName.setText(model.getTopicName());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{
      TextView Student1,Student2,Student3,TopicName;
        public MyViewHolder(@Nullable View itemView){
              super(itemView);
              Student1 = itemView.findViewById(R.id.textstud1name);
            Student2 = itemView.findViewById(R.id.textstud2name);
            Student3 = itemView.findViewById(R.id.textstud3name);
            TopicName = itemView.findViewById(R.id.txttopicname);
        }
    }

}
