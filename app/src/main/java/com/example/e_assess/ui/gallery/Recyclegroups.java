package com.example.e_assess.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.example.e_assess.Choosestudent;
import com.example.e_assess.R;
import com.example.e_assess.chooseExam;


import androidx.recyclerview.widget.RecyclerView;

import com.example.e_assess.chooseExam;
import com.example.e_assess.ui.gallery.Recyclegroups;
import com.example.e_assess.ui.gallery.Groups;

import java.util.ArrayList;

import javax.annotation.Nullable;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class Recyclegroups extends RecyclerView.Adapter<com.example.e_assess.ui.gallery.Recyclegroups.MyViewHolder> {

        ArrayList<Groups> mlist;
        Context context;

        public Recyclegroups(Context context, ArrayList<Groups> mlist){
            this.mlist = mlist;
            this.context= context;
        }

        public Recyclegroups(Context context) {
            this.context = context;
        }


        @NonNull
        @Override
        public com.example.e_assess.ui.gallery.Recyclegroups.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(context).inflate(R.layout.activity_choossegroup,parent,false);
            return new com.example.e_assess.ui.gallery.Recyclegroups.MyViewHolder(v);
        }
        //public com.example.e_assess.ui.home.Recyle.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View v = LayoutInflater.from(context).inflate(R.layout.card_view,parent,false);
        //return new com.example.e_assess.ui.home.Guide.MyViewHolder(v);
        //}
        public void onBindViewHolder(@NonNull com.example.e_assess.ui.gallery.Recyclegroups.MyViewHolder holder, int position) {
            final  Groups groups = mlist.get(position);
            holder.Groupno1.setText(groups.GroupNo);
            holder.gru2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Intent intent=new Intent(context,Choosestudent.class);
                    intent.putExtra("stud11name",groups.getStudent1());
                    intent.putExtra("stud22name",groups.getStudent2());
                    intent.putExtra("stud33name",groups.getStudent3());
                    intent.putExtra("TopiccName",groups.getTopicName());
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
            TextView Groupno1,gru2;

            public MyViewHolder(@Nullable View itemView){
                super(itemView);
                Groupno1=itemView.findViewById(R.id.grpno1);
                gru2=itemView.findViewById(R.id.textView3);
            }
        }

    }

