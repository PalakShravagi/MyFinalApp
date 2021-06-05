package com.example.e_assess.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_assess.R;
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
        Guide guide = mlist.get(position);

        holder.GroupNo.setText(guide.getGroupNo());
        holder.TopicName.setText(guide.getTopicName());
    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView GroupNo,TopicName;
        public MyViewHolder(@Nullable View itemView){
            super(itemView);
            GroupNo=itemView.findViewById(R.id.grpno);
            TopicName = itemView.findViewById(R.id.top);
        }
    }

}