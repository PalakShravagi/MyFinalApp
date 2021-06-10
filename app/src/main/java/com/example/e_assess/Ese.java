package com.example.e_assess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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

import android.text.Editable;
import android.text.TextWatcher;
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
import com.google.android.material.internal.TextWatcherAdapter;
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
public class Ese extends AppCompatActivity {
    String  stu11,stu12,stu13,stu14,stu15,stu21,stu22,stu23,stu24,stu25,stu31,stu32,stu34,stu35,stu33,finalmarksstud1,finalmarksstud2,finalmarksstud3;
    TextView stu1total,stu2total,stu3total;
    EditText stu1R1,stu1R2,stu1R3,stu1R4,stu1R5,stu2R1,stu2R2,stu2R3,stu2R4,stu2R5,stu3R1,stu3R2,stu3R3,stu3R4,stu3R5;
    String Uid;
    private Button save,totals11ise2,totals22ise2,totals33ise2;
    TextView stud1,stud2,stud3;
    private FirebaseDatabase firebase;
    private DatabaseReference database;
    private FirebaseAuth auth;
    private DatabaseReference mRootRef;
    FirebaseUser user ;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ese);

        // for taking the names of student from the activity.
        stud1 = findViewById(R.id.stud1ese);
        stud2 = findViewById(R.id.stud2ese);
        stud3 = findViewById(R.id.stud3ese);
        stud1.setText(getIntent().getStringExtra("stud1name"));
        stud2.setText(getIntent().getStringExtra("stud2name"));
        stud3.setText(getIntent().getStringExtra("stud3name"));
        final String stud1n = getIntent().getStringExtra("stud1name").toString();
        final String stud2n = getIntent().getStringExtra("stud2name").toString();
        final String stud3n = getIntent().getStringExtra("stud3name").toString();





        auth = FirebaseAuth.getInstance();
        mRootRef = FirebaseDatabase.getInstance().getReference();

        firebase=FirebaseDatabase.getInstance();
        user= FirebaseAuth.getInstance().getCurrentUser();
        Uid=user.getUid();
        Toast.makeText(this, Uid, Toast.LENGTH_SHORT).show();
        database=firebase.getReference();
        totals11ise2=findViewById(R.id.totaleses1);
        totals22ise2=findViewById(R.id.totaleses2);
        totals33ise2=findViewById(R.id.totaleses3);
        save = findViewById(R.id.savedatabaseese);
        stu1R1=(EditText)findViewById(R.id.rubric1esestu1) ;
        stu1R2=(EditText)findViewById(R.id.rubric2esestu1);
        stu1R3=(EditText)findViewById(R.id.rubric3esestu1);
        stu1R4=(EditText)findViewById(R.id.rubric4esestu1);
        stu1R5=(EditText)findViewById(R.id.rubric5esestu1);
        stu1total=(TextView) findViewById(R.id.Totalese);
        stu2R1=(EditText)findViewById(R.id.rubric1esestu2) ;
        stu2R2=(EditText)findViewById(R.id.rubric2esestu2) ;
        stu2R3=(EditText)findViewById(R.id.rubric3esestu2) ;
        stu2R4=(EditText)findViewById(R.id.rubric4esestu2) ;
        stu2R5=(EditText)findViewById(R.id.rubric5esestu2) ;
        stu2total=(TextView) findViewById(R.id.Total2ese);
        stu3R1=(EditText)findViewById(R.id.rubric1esestu3);
        stu3R2=(EditText)findViewById(R.id.rubric2esestu3);
        stu3R3=(EditText)findViewById(R.id.rubric3esestu3);
        stu3R4=(EditText)findViewById(R.id.rubric4esestu3);
        stu3R5=(EditText)findViewById(R.id.rubric5esestu3);
        stu3total= (TextView)findViewById(R.id.Total3ese) ;

        /*TextWatcher textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!stu1R1.getText().toString().equals("")&&!stu1R2.getText().toString().equals("")&&stu1R3.getText().toString().equals("")&&!stu1R4.getText().toString().equals("")&&stu1R5.getText().toString().equals(""))
                {

                    int R11=Integer.parseInt(stu1R1.getText().toString());
                    int R12=Integer.parseInt(stu1R2.getText().toString());
                    int R13=Integer.parseInt(stu1R3.getText().toString());
                    int R14=Integer.parseInt(stu1R4.getText().toString());
                    int R15=Integer.parseInt(stu1R5.getText().toString());
                    stu1total.setText(String.valueOf(R11 + R12 + R13 + R14 + R15));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        stu1R1.addTextChangedListener(textWatcher);
        stu1R2.addTextChangedListener(textWatcher);
        stu1R3.addTextChangedListener(textWatcher);
        stu1R4.addTextChangedListener(textWatcher);
        stu1R5.addTextChangedListener(textWatcher);

        TextWatcher textWatcher1=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!stu2R1.getText().toString().equals("")&&!stu2R2.getText().toString().equals("")&&stu2R3.getText().toString().equals("")&&!stu2R4.getText().toString().equals("")&&stu2R5.getText().toString().equals(""))
                {

                    int R21=Integer.parseInt(stu1R1.getText().toString());
                    int R22=Integer.parseInt(stu1R2.getText().toString());
                    int R23=Integer.parseInt(stu1R3.getText().toString());
                    int R24=Integer.parseInt(stu1R4.getText().toString());
                    Integer R25=Integer.parseInt(stu1R5.getText().toString());
                    Toast.makeText(Assignmarksise.this, "Pranav", Toast.LENGTH_SHORT).show();
                //    int t = R21+R22+R23+R24+R24+R25;
                 //   String s = t.toString();
                    stu2total.setText(String.valueOf(R21 + R22 + R23 + R24 + R25));


                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        stu2R1.addTextChangedListener(textWatcher1);
        stu2R2.addTextChangedListener(textWatcher1);
        stu2R3.addTextChangedListener(textWatcher1);
        stu2R4.addTextChangedListener(textWatcher1);
        stu2R5.addTextChangedListener(textWatcher1);

        TextWatcher textWatcher2=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!stu3R1.getText().toString().equals("")&&!stu3R2.getText().toString().equals("")&&stu3R3.getText().toString().equals("")&&!stu3R4.getText().toString().equals("")&&stu3R5.getText().toString().equals(""))
                {
                    int R31=Integer.parseInt(stu1R1.getText().toString());
                    int R32=Integer.parseInt(stu1R2.getText().toString());
                    int R33=Integer.parseInt(stu1R3.getText().toString());
                    int R34=Integer.parseInt(stu1R4.getText().toString());
                    int R35=Integer.parseInt(stu1R5.getText().toString());
                    stu3total.setText(String.valueOf(R31 + R32 + R33 + R34 + R35));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        stu3R1.addTextChangedListener(textWatcher2);
        stu3R2.addTextChangedListener(textWatcher2);
        stu3R3.addTextChangedListener(textWatcher2);
        stu3R4.addTextChangedListener(textWatcher2);
        stu3R5.addTextChangedListener(textWatcher2);*/

        totals11ise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stu11=stu1R1.getText().toString();
                stu12=stu1R2.getText().toString();
                stu13=stu1R3.getText().toString();
                stu14=stu1R4.getText().toString();
                stu15=stu1R5.getText().toString();
                stu1R1.setError(null);
                stu1R2.setError(null);
                stu1R3.setError(null);
                stu1R4.setError(null);
                stu1R5.setError(null);
                if(stu11.isEmpty()){
                    stu1R1.setError("Field Should not be empty");
                    stu1R1.setFocusable(true);
                }else if (Integer.parseInt(stu11)>5||Integer.parseInt(stu11)<0 ) {
                    stu1R1.setError("Marks should be between 0 to 5");
                    stu1R1.setFocusable(true);
                }
                else if(stu12.isEmpty()){
                    stu1R2.setError("Field Should not be empty");
                    stu1R2.setFocusable(true);
                }else if (Integer.parseInt(stu12)>5||Integer.parseInt(stu12)<0 ) {
                    stu1R2.setError("Marks should be between 0 to 5");
                    stu1R2.setFocusable(true);
                }
                else if(stu13.isEmpty()){
                    stu1R3.setError("Field Should not be empty");
                    stu1R3.setFocusable(true);
                }else if (Integer.parseInt(stu13)>5||Integer.parseInt(stu13)<0) {
                    stu1R3.setError("Marks should be between 0 to 5");
                    stu1R3.setFocusable(true);
                }
                else if(stu14.isEmpty()){
                    stu1R4.setError("Field Should not be empty");
                    stu1R4.setFocusable(true);
                }else if (Integer.parseInt(stu14)>5||Integer.parseInt(stu14)<0 ) {
                    stu1R4.setError("Marks should be between 0 to 5");
                    stu1R4.setFocusable(true);
                }
                else if(stu15.isEmpty()){
                    stu1R5.setError("Field Should not be empty");
                    stu1R5.setFocusable(true);
                }else if (Integer.parseInt(stu15)>5||Integer.parseInt(stu15)<0) {
                    stu1R5.setError("Marks should be between 0 to 5");
                    stu1R5.setFocusable(true);
                }
                else
                {
                    int R11 = Integer.parseInt(stu11);
                    int R12 = Integer.parseInt(stu12);
                    int R13 = Integer.parseInt(stu13);
                    int R14 = Integer.parseInt(stu14);
                    int R15 = Integer.parseInt(stu15);
                    stu1total.setText(String.valueOf(R11 + R12 + R13 + R14 + R15));
                }
            }
        });

        totals22ise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stu21=stu2R1.getText().toString();
                stu22=stu2R2.getText().toString();
                stu23=stu2R3.getText().toString();
                stu24=stu2R4.getText().toString();
                stu25=stu2R5.getText().toString();
                stu2R1.setError(null);
                stu2R2.setError(null);
                stu2R3.setError(null);
                stu2R4.setError(null);
                stu2R5.setError(null);
                if(stu21.isEmpty()){
                    stu2R1.setError("Field Should not be empty");
                    stu2R1.setFocusable(true);
                }else if (Integer.parseInt(stu21)>5||Integer.parseInt(stu21)<0 ) {
                    stu2R1.setError("Marks should be between 0 to 5");
                    stu2R1.setFocusable(true);
                }
                else if(stu22.isEmpty()){
                    stu2R2.setError("Field Should not be empty");
                    stu2R2.setFocusable(true);
                }else if (Integer.parseInt(stu22)>5||Integer.parseInt(stu22)<0 ) {
                    stu2R2.setError("Marks should be between 0 to 5");
                    stu2R2.setFocusable(true);
                }
                else if(stu23.isEmpty()){
                    stu2R3.setError("Field Should not be empty");
                    stu2R3.setFocusable(true);
                }else if (Integer.parseInt(stu23)>5||Integer.parseInt(stu23)<0) {
                    stu2R3.setError("Marks should be between 0 to 5");
                    stu2R3.setFocusable(true);
                }
                else if(stu24.isEmpty()){
                    stu2R4.setError("Field Should not be empty");
                    stu2R4.setFocusable(true);
                }else if (Integer.parseInt(stu24)>5||Integer.parseInt(stu24)<0 ) {
                    stu2R4.setError("Marks should be between 0 to 5");
                    stu2R4.setFocusable(true);
                }
                else if(stu25.isEmpty()){
                    stu2R5.setError("Field Should not be empty");
                    stu2R5.setFocusable(true);
                }else if (Integer.parseInt(stu25)>5||Integer.parseInt(stu25)<0) {
                    stu2R5.setError("Marks should be between 0 to 5");
                    stu2R5.setFocusable(true);
                }
                else
                {
                    int R21 = Integer.parseInt(stu21);
                    int R22 = Integer.parseInt(stu22);
                    int R23 = Integer.parseInt(stu23);
                    int R24 = Integer.parseInt(stu24);
                    int R25 = Integer.parseInt(stu25);
                    stu2total.setText(String.valueOf(R21 + R22 + R23 + R24 + R25));
                }
            }
        });

        totals33ise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stu31=stu3R1.getText().toString();
                stu32=stu3R2.getText().toString();
                stu33=stu3R3.getText().toString();
                stu34=stu3R4.getText().toString();
                stu35=stu3R5.getText().toString();
                stu3R1.setError(null);
                stu3R2.setError(null);
                stu3R3.setError(null);
                stu3R4.setError(null);
                stu3R5.setError(null);
                if(stu31.isEmpty()){
                    stu3R1.setError("Field Should not be empty");
                    stu3R1.setFocusable(true);
                }else if (Integer.parseInt(stu31)>5||Integer.parseInt(stu31)<0 ) {
                    stu3R1.setError("Marks should be between 0 to 5");
                    stu3R1.setFocusable(true);
                }else if(stu32.isEmpty()){
                    stu3R2.setError("Field Should not be empty");
                    stu3R2.setFocusable(true);
                }else if (Integer.parseInt(stu32)>5||Integer.parseInt(stu32)<0 ) {
                    stu3R2.setError("Marks should be between 0 to 5");
                    stu3R2.setFocusable(true);
                }else if(stu33.isEmpty()){
                    stu3R3.setError("Field Should not be empty");
                    stu3R3.setFocusable(true);
                }else if (Integer.parseInt(stu33)>5||Integer.parseInt(stu33)<0) {
                    stu3R3.setError("Marks should be between 0 to 5");
                    stu3R3.setFocusable(true);
                }else if(stu34.isEmpty()){
                    stu3R4.setError("Field Should not be empty");
                    stu3R4.setFocusable(true);
                }else if (Integer.parseInt(stu34)>5||Integer.parseInt(stu34)<0 ) {
                    stu3R4.setError("Marks should be between 0 to 5");
                    stu3R4.setFocusable(true);
                }else if(stu35.isEmpty()){
                    stu3R5.setError("Field Should not be empty");
                    stu3R5.setFocusable(true);
                }else if (Integer.parseInt(stu35)>5||Integer.parseInt(stu35)<0) {
                    stu3R5.setError("Marks should be between 0 to 5");
                    stu3R5.setFocusable(true);
                }
                else
                {
                    int R31=Integer.parseInt(stu3R1.getText().toString());
                    int R32=Integer.parseInt(stu3R2.getText().toString());
                    int R33=Integer.parseInt(stu3R3.getText().toString());
                    int R34=Integer.parseInt(stu3R4.getText().toString());
                    int R35=Integer.parseInt(stu3R5.getText().toString());
                    stu3total.setText(String.valueOf(R31 + R32 + R33 + R34 + R35));
                }
            }
        });



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stu11= stu1R1.getText().toString();
                stu12= stu1R2.getText().toString();
                stu13= stu1R3.getText().toString();
                stu14= stu1R4.getText().toString();
                stu15= stu1R5.getText().toString();
                finalmarksstud1=stu1total.getText().toString();
                stu21= stu2R1.getText().toString();
                stu22= stu2R2.getText().toString();
                stu23= stu2R3.getText().toString();
                stu24= stu2R4.getText().toString();
                stu25= stu2R5.getText().toString();
                finalmarksstud2=stu2total.getText().toString();
                stu31= stu3R1.getText().toString();
                stu32= stu3R2.getText().toString();
                stu33= stu3R3.getText().toString();
                stu34= stu3R4.getText().toString();
                stu35= stu3R5.getText().toString();
                finalmarksstud3=stu3total.getText().toString();

                if (stu11.isEmpty() || stu12.isEmpty()||stu13.isEmpty() || stu14.isEmpty() || stu15.isEmpty() || finalmarksstud1.isEmpty()||stu21.isEmpty() || stu22.isEmpty()||stu23.isEmpty() || stu24.isEmpty() || stu25.isEmpty() || finalmarksstud2.isEmpty()||
                        stu31.isEmpty() || stu32.isEmpty()||stu33.isEmpty() || stu34.isEmpty() || stu35.isEmpty() || finalmarksstud3.isEmpty()) {
                    Snackbar.make(v, "Missing Field!", BaseTransientBottomBar.LENGTH_LONG).show();
                } else {
                    Map<String, String> student1La1marks = new HashMap<String, String>();
                    student1La1marks.put("TotalEse",finalmarksstud1);
                    student1La1marks.put("Objective Achieved",stu11);
                    student1La1marks.put("Result And Analysis",stu12);
                    student1La1marks.put("Novelty",stu13);
                    student1La1marks.put("Presentation skills",stu14);
                    student1La1marks.put("Application(social,dept,eco,etc)",stu15);

                    mRootRef.child("Marks").child(stud1n).child("ESE").setValue(student1La1marks)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    Intent intent = new Intent(Ese.this,navActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Ese.this, " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });


                    // for stud2
                    Map<String, String> student2La1marks = new HashMap<String, String>();
                    student2La1marks.put("TotalEse",finalmarksstud2);
                    student2La1marks.put("Objective Achieved",stu21);
                    student2La1marks.put("Result And Analysis",stu22);
                    student2La1marks.put("Novelty",stu23);
                    student2La1marks.put("Presentation skills",stu24);
                    student2La1marks.put("Application(social,dept,eco,etc)",stu25);

                    mRootRef.child("Marks").child(stud2n).child("ESE").setValue(student2La1marks)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    Intent intent = new Intent(Ese.this,navActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Ese.this, " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });



                    // for stud 3
                    Map<String, String> student3La1marks = new HashMap<String, String>();
                    student3La1marks.put("TotalEse",finalmarksstud3);
                    student3La1marks.put("Objective Achieved",stu31);
                    student3La1marks.put("Result And Analysis",stu32);
                    student3La1marks.put("Novelty",stu33);
                    student3La1marks.put("Presentation skills",stu34);
                    student3La1marks.put("Application(social,dept,eco,etc)",stu35);

                    mRootRef.child("Marks").child(stud3n).child("ESE").setValue(student3La1marks)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Ese.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Ese.this,navActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Ese.this, " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });



                }
            }

        });
    }
}