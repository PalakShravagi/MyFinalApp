  package com.example.e_assess.ui.HomeAdmin;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_assess.R;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


  public class HomeAdmin_fragment  extends Fragment{
      RecyclerView review;
      MyAdapter adapter;
      private FirebaseAuth auth;
      private FirebaseUser user;
      private DatabaseReference reference;
      String userID;
     private HomeAdminViewModel homeViewModel;
     Context context;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                new ViewModelProvider( this).get(HomeAdminViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home_admin, container, false);
        review = (RecyclerView) root.findViewById(R.id.revieww);
        review.setLayoutManager(new LinearLayoutManager(getContext()));
        context = container.getContext();
        reference = FirebaseDatabase.getInstance().getReference("Users");
       // FirebaseRecyclerOptions<model> options =
             //   new FirebaseRecyclerOptions.Builder<model>()
                  //      .setQuery(FirebaseDatabase.getInstance().getReference("Users"), model.class)
                  //      .build();
        ArrayList<model> options = new ArrayList<model>();
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                            String uid =dataSnapshot.getKey();
                            String name_user;
                            for(DataSnapshot datas : dataSnapshot.getChildren()){
                                if(datas.getKey().equals("name")){
                                    name_user = datas.getValue(String.class);
                                    model mod = new model(name_user,uid);
                                    Log.i("mod.name",mod.getName());
                                    Log.i("mod.uid",mod.getUerid());
                                   boolean b =  options.add(mod);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

      adapter = new MyAdapter(context,options);
      review.setAdapter(adapter);



        return root;
    }



}
