package com.example.e_assess;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> {
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {
    holder.txtcode.setText(model.getCode());
        holder.txtname.setText(model.getName());
        holder.txtpost.setText(model.getPost());
    }

    @NonNull
    @Override

    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        TextView txtcode;
        TextView txtname;
        TextView txtpost;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            txtcode = itemView.findViewById(R.id.codetxt);
            txtname = itemView.findViewById(R.id.nametxt);
            txtpost = itemView.findViewById(R.id.posttxt);

        }
    }
}
