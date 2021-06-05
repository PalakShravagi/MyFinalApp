package com.example.e_assess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;

import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class addStudent extends AppCompatActivity {
    String groupNo,topicName,stu1,stu2,stu3,Uid;
    private Button save;
    private FirebaseDatabase firebase;
    private DatabaseReference database;
    private FirebaseAuth auth;
    private DatabaseReference mRootRef;
    FirebaseUser user ;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        //
        auth = FirebaseAuth.getInstance();
        mRootRef = FirebaseDatabase.getInstance().getReference();



        firebase=FirebaseDatabase.getInstance();
        user= FirebaseAuth.getInstance().getCurrentUser();
        Uid=user.getUid();
        Toast.makeText(this, Uid, Toast.LENGTH_SHORT).show();
        database=firebase.getReference();
        EditText editTextgroupno, editTextTopicName, editTextStudent1, editTextStudent2, editTextStudent3;
        save = findViewById(R.id.savedatabase);
        editTextgroupno = (EditText) findViewById(R.id.editTextgroupno);
        editTextTopicName = (EditText) findViewById(R.id.editTextTopicName);
        editTextStudent1 = (EditText) findViewById(R.id.editTextStudent1);
        editTextStudent2 = (EditText) findViewById(R.id.editTextStudent2);
        editTextStudent3 = (EditText) findViewById(R.id.editTextStudent3);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupNo = editTextgroupno.getText().toString();
                topicName = editTextTopicName.getText().toString();
                stu1 = editTextStudent1.getText().toString();
                stu2 = editTextStudent2.getText().toString();
                stu3 = editTextStudent3.getText().toString();
                if (groupNo.isEmpty() || topicName.isEmpty() || stu1.isEmpty() || stu2.isEmpty() || stu3.isEmpty()) {
                    Snackbar.make(v, "Missing Field!", BaseTransientBottomBar.LENGTH_LONG).show();
                } else {
                    Map<String, String> studentData = new HashMap<String, String>();
                    studentData.put("TopicName", topicName);
                    studentData.put("GroupNo",groupNo);
                    studentData.put("Student1", stu1);
                    studentData.put("Student2", stu2);
                    studentData.put("Student3", stu3);
//                HashMap<String,Object> hashMap = new HashMap<>();
//                hashMap.put("editTextgroupno",groupNo);
//                hashMap.put("editTextTopicName",topicName);
//                hashMap.put("editTextStudent1",stu1);
//                hashMap.put("editTextStudent2",stu2);
//                hashMap.put("editTextStudent3",stu3);

                   // database.child("Users").child(Uid).child("groups").child(groupNo).setValue(studentData)
                    mRootRef.child("Groups").child(auth.getCurrentUser().getUid()).setValue(studentData)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(addStudent.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(addStudent.this, navActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(addStudent.this, " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }

        });



    }
}