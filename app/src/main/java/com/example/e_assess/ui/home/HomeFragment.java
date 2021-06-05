package com.example.e_assess.ui.home;

import android.content.Context;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_assess.R;
//import com.example.e_assess.adapterGroups;

import com.example.e_assess.ui.home.Recycle;
import com.example.e_assess.ui.home.Guide;
import com.example.e_assess.ui.home.HomeViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView review;
    Context context;
    private DatabaseReference reference;
    private Recycle adapter;
    FirebaseAuth auth;
    private ArrayList<Guide> list;
    FirebaseUser user;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        review = (RecyclerView) root.findViewById(R.id.recycle2);
        review.setLayoutManager(new LinearLayoutManager(getContext()));
        context = container.getContext();
        list = new ArrayList<>();
        adapter = new Recycle(context, list);
        user = FirebaseAuth.getInstance().getCurrentUser();
        String Uid = user.getUid().toString();
        review.setAdapter(adapter);
        reference = FirebaseDatabase.getInstance().getReference().child("Groups").child(Uid);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot data : snapshot.getChildren()) {
                    //   ModelDashboard mod = data.getValue(ModelDashboard.class);
                    // list.add(mod);
                    String stud1, stud2, stud3, topic, grpno;
                    //for(DataSnapshot data : dataSnapshot.getChildren()){
                    grpno = data.child("GroupNo").getValue(String.class);
                    stud1 = data.child("Student1").getValue(String.class);
                    stud2 = data.child("Student2").getValue(String.class);
                    stud3 = data.child("Student3").getValue(String.class);
                    topic = data.child("TopicName").getValue(String.class);
                    Guide model = new Guide(grpno, stud1, stud2, stud3, topic);
                    list.add(model);
                    // adapter.notifyDataSetChanged();

                    //}
                }
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return root;

    }
}