
/*

package com.example.e_assess.ui.admingroup;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.e_assess.R;
import com.example.e_assess.ui.HomeAdmin.model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BlankFragment extends Fragment {

    private BlankViewModel mViewModel;
    RecyclerView review;
    MyadapterGroupAdmin adapter;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private DatabaseReference reference;
    String userID;
    Context context;
     String useridguid ;

    public BlankFragment(String uidd) {
        useridguid = uidd;
        return;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.blank_fragment, container, false);

        review = (RecyclerView) root.findViewById(R.id.reviewid);
        review.setLayoutManager(new LinearLayoutManager(getContext()));
        context = container.getContext();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        ArrayList<moduleGroups> options = new ArrayList<moduleGroups>();
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // for the main obj
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String uid =dataSnapshot.getKey();
                    String name_user;
                    // for key value pair like name|| code||groups
                    for(DataSnapshot datas : dataSnapshot.getChildren()){
                        if(datas.getKey().equals("groups") &&  dataSnapshot.getKey().equals(uid)){
                            String stud1,stud2,stud3,topic;
                            for(DataSnapshot data : datas.getChildren()) {
                                for(DataSnapshot dat:data.getChildren()) {
                                    for(DataSnapshot da:data.getChildren()) {
                                         stud1 = dat.getValue(String.class);
                                        stud2 = dat.getValue(String.class);
                                         stud3 = dat.getValue(String.class);
                                         topic = dat.getValue(String.class);
                                    //    moduleGroups mode = new mode(stud1,stud2,stud3,topic);
                                        // Log.i("Student1", mod.getStudent1());
                                        //  Log.i("Student1", mod.getStudent2());
                                        //  Log.i("Student1", mod.getStudent3());
                                        //  Log.i("Student1", mod.getTopicName());
                                     //   boolean b = options.add(mod);
                                    }
                                    adapter.notifyDataSetChanged();
                                }



                            }
                            /*
                            name_user = datas.getValue(String.class);
                            moduleGroups mod = new moduleGroups(name_user,uid);
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

        adapter = new MyadapterGroupAdmin(context,options);
        review.setAdapter(adapter);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BlankViewModel.class);
        // TODO: Use the ViewModel
    }

}
*/