package com.example.e_assess;
/*

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class adapterGroups extends FirebaseRecyclerAdapter<Groupno,adapterGroups.MyViewHolder> {

    ArrayList<Groupno> mList;
    Context context;

    public adapterGroups(Context context , ArrayList<Groupno> mList){
        super(mList);
        this.mList = mList;
        this.context = context;
    }

    public adapterGroups(@NonNull FirebaseRecyclerOptions<Groupno> options) {
        super(options);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.singlerowgroupclas , parent ,false);
        return new MyViewHolder(v);

    }
    @Override
    public int getItemCount() {
        return mList.size();
    }


    protected void onBindViewHolder(@NonNull adapterGroups.MyViewHolder holder, int position, @NonNull Groupno model) {
        holder.txtstud1.setText(model.getStudent1());
        holder.txtstud2.setText(model.getStudent2());
        holder.txtstud3.setText(model.getStudent3());
        holder.txttopic.setText(model.getTopicName());
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txttopic,txtstud1,txtstud2,txtstud3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtstud1 = itemView.findViewById(R.id.txtstud1);
            txtstud2 = itemView.findViewById(R.id.txtstud2);
            txtstud3 = itemView.findViewById(R.id.txtstud3);
            txttopic = itemView.findViewById(R.id.txttop);
        }
    }
}

*/