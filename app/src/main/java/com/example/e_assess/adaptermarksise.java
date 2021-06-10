package com.example.e_assess;

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
import com.example.e_assess.Choosestudent;
import java.util.ArrayList;


import javax.annotation.Nullable;

public class adaptermarksise extends RecyclerView.Adapter<com.example.e_assess.adaptermarksise.MyViewHolder> {
        ArrayList<Marks> mlist;
        Context context;

public adaptermarksise(Context context, ArrayList<Marks> mlist){
        this.mlist = mlist;
        this.context= context;
        }

public adaptermarksise(Context context) {
        this.context = context;
        }



@NonNull
@Override
public adaptermarksise.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_recyclemarks,parent,false);
        return new adaptermarksise.MyViewHolder(v);
        }
//public com.example.e_assess.ui.home.Recyle.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//View v = LayoutInflater.from(context).inflate(R.layout.card_view,parent,false);
//return new com.example.e_assess.ui.home.Guide.MyViewHolder(v);
//}
public void onBindViewHolder(@NonNull adaptermarksise.MyViewHolder holder, int position) {
final   Marks marks = mlist.get(position);
        holder.Totalise.setText(marks.getTotalise());
        holder.R1ise1.setText(marks.getR1ise1());
        holder.R2ise1.setText(marks.getR2ise1());
        holder.R3ise1.setText(marks.getR3ise1());
        holder.R4ise1.setText(marks.getR4ise1());
        holder.R5ise1.setText(marks.getR5ise1());
        /*holder.asignmarksicon.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent intent = new Intent(context, Choosestudent.class);
        intent.putExtra("stud1name",guide.getStudent1());
        intent.putExtra("stud2name",guide.getStudent2());
        intent.putExtra("stud3name",guide.getStudent3());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        }
        });*/
        }


@Override
public int getItemCount() {
        return mlist.size();
        }

public static  class MyViewHolder extends RecyclerView.ViewHolder{
    TextView Totalise,R1ise1,R2ise1,R3ise1,R4ise1,R5ise1;
    //R1ise2,R2ise2,R3ise2,R4ise2,R5ise2,R1mse,
     //       R2mse,R3mse,R4mse,R5mse,R1ese,R2ese,R3ese,R4ese,R5ese;
   //TextView Totalise2,Totalmse,Totalese,
    public MyViewHolder(@Nullable View itemView){
        super(itemView);
       Totalise=itemView.findViewById(R.id.Totalstud1);

        R1ise1=itemView.findViewById(R.id.rubric1stud1);
        R2ise1=itemView.findViewById(R.id.rubric2stud1);
        R3ise1=itemView.findViewById(R.id.rubric3stud1);
        R4ise1=itemView.findViewById(R.id.rubric4stud1);
        R5ise1=itemView.findViewById(R.id.rubric5stud1);
        /*Totalise2=itemView.findViewById(R.id.Totalise22);
        Totalmse=itemView.findViewById(R.id.Totalmse11);
        Totalese=itemView.findViewById(R.id.Totalese11);
        R1ise2=itemView.findViewById(R.id.rubric1ise2stud1);
        R2ise2=itemView.findViewById(R.id.rubric2ise2stud1);
        R3ise2=itemView.findViewById(R.id.rubric3ise2stud1);
        R4ise2=itemView.findViewById(R.id.rubric4ise2stud1);
        R5ise2=itemView.findViewById(R.id.rubric5ise2stud1);
        R1mse=itemView.findViewById(R.id.rubric1msestud1);
        R2mse=itemView.findViewById(R.id.rubric2msestud1);
        R3mse=itemView.findViewById(R.id.rubric3msestud1);
        R4mse=itemView.findViewById(R.id.rubric4msestud1);
        R5mse=itemView.findViewById(R.id.rubric5msestud1);
        R1ese=itemView.findViewById(R.id.rubric1esestud1);
        R2ese=itemView.findViewById(R.id.rubric2esestud1);
        R3ese=itemView.findViewById(R.id.rubric3esestud1);
        R4ese=itemView.findViewById(R.id.rubric4esestud1);
        R5ese=itemView.findViewById(R.id.rubric5esestud1);*/
    }
}

}