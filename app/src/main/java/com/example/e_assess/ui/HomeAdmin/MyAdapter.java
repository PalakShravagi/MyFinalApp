package com.example.e_assess.ui.HomeAdmin;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_assess.R;
//import com.example.e_assess.ui.admingroup.BlankFragment;
import com.example.e_assess.ui.admingroup.BlankViewModel;


import android.content.Context;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<model> mlist;
    Context context;
    public MyAdapter( Context context,ArrayList<model> mlist){
        this.mlist=mlist;
        this.context =context;

    }
    public MyAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.singlerowdesign,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        model model= mlist.get(position);
        holder.name.setText(model.getName());

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "hii " + model.getUerid().toString(), Toast.LENGTH_SHORT).show();
                //context.startActivity(new Intent(context, GroupsShowAdminViewModel.class));
                String uidd = model.getUerid();
              //  AppCompatActivity activity = (AppCompatActivity)v.getContext();
              //  BlankFragment frag =new BlankFragment(uidd);
             //   activity.getSupportFragmentManager().beginTransaction().replace(R.id.ganpatibappamourya,frag).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,Query,status,Feedback;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
          name = itemView.findViewById(R.id.nametxt);
        }
    }
}
