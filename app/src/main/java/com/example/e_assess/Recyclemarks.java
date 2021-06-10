package com.example.e_assess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.e_assess.ui.home.Guide;
import com.example.e_assess.ui.home.Recycle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Recyclemarks extends AppCompatActivity {
    RecyclerView review;
    Context context;
    private DatabaseReference reference,ref;
    private adaptermarksise recyclemarks;
    FirebaseAuth auth;
    private ArrayList<Marks> list;
    FirebaseUser user;
    String userid, nameOfGuide;
    String student1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclemarks);
        review=findViewById(R.id.reviewmarks);
        user = FirebaseAuth.getInstance().getCurrentUser();
        String Uid = user.getUid().toString();
        review.setAdapter(recyclemarks);
        student1 =getIntent().getStringExtra("stud1name").toString();
         final String stuname=student1;
        //    for getting the details of the person who logg in !!
        userid = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
        ref = FirebaseDatabase.getInstance().getReference().child("Groups").child(userid);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                    }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
            /*@Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dat : snapshot.getChildren()) {
                    //final String nameOfstud1 = snapshot.child("Student1").getValue(String.class);
                    // Log.i("nameg the md",nameOfGuide);
                    reference = FirebaseDatabase.getInstance().getReference().child("Marks");
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //Groups
                            for (DataSnapshot datas : snapshot.getChildren()) {
                                //id under the group
                                for (DataSnapshot data : datas.getChildren()) {
                                    //name of guide
                                    String s = data.getKey();
                                    if (s.equals(nameOfGuide)) {
                                        for (DataSnapshot dat : data.getChildren()) {
                                            String stud1, stud2, stud3, topic, grpno;
                                            grpno = dat.child("GroupNo").getValue(String.class);
                                            stud1 = dat.child("Student1").getValue(String.class);
                                            stud2 = dat.child("Student2").getValue(String.class);
                                            stud3 = dat.child("Student3").getValue(String.class);
                                            topic = dat.child("TopicName").getValue(String.class);
                                            Marks marks = new Guide(grpno, stud1, stud2, stud3, topic);
                                            list.add(model);
                                        }
                                        recyclemarks.notifyDataSetChanged();
                                    }
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });*/

                    //Log.i("name of the guide ",name);


                    // end of the trial


                    return root;

                }
            }
