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
public class Assignmarksise extends AppCompatActivity {
    String  stu11,stu12,stu13,stu14,stu15,stu21,stu22,stu23,stu24,stu25,stu31,stu32,stu34,stu35,stu33,finalmarksstud1,finalmarksstud2,finalmarksstud3;
    TextView stu1total,stu2total,stu3total;
    String Uid;
    private Button save;
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
        setContentView(R.layout.activity_assignmarks);

        // for taking the names of student from the activity.
        stud1 = findViewById(R.id.stud1ise);
        stud2 = findViewById(R.id.stud2ise);
        stud3 = findViewById(R.id.stud3ise);
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
        EditText stu1R1,stu1R2,stu1R3,stu1R4,stu1R5,stu2R1,stu2R2,stu2R3,stu2R4,stu2R5,stu3R1,stu3R2,stu3R3,stu3R4,stu3R5;
        save = findViewById(R.id.savedatabaseise1);
        stu1R1=(EditText)findViewById(R.id.rubric1stu1) ;
        stu1R2=(EditText)findViewById(R.id.rubric2stu1);
        stu1R3=(EditText)findViewById(R.id.rubric3stu1);
        stu1R4=(EditText)findViewById(R.id.rubric4stu1);
        stu1R5=(EditText)findViewById(R.id.rubric5stu1);
        stu1total= (TextView) findViewById(R.id.Total);
        stu2R1=(EditText)findViewById(R.id.rubric1stu2) ;
        stu2R2=(EditText)findViewById(R.id.rubric2stu2) ;
        stu2R3=(EditText)findViewById(R.id.rubric3stu2) ;
        stu2R4=(EditText)findViewById(R.id.rubric4stu2) ;
        stu2R5=(EditText)findViewById(R.id.rubric5stu2) ;
        stu2total=(TextView) findViewById(R.id.Total2);
        stu3R1=(EditText)findViewById(R.id.rubric1stu3);
        stu3R2=(EditText)findViewById(R.id.rubric2stu3);
        stu3R3=(EditText)findViewById(R.id.rubric3stu3);
        stu3R4=(EditText)findViewById(R.id.rubric4stu3);
        stu3R5=(EditText)findViewById(R.id.rubric5stu3);
        stu3total=(TextView) findViewById(R.id.Total3) ;

        TextWatcher textWatcher=new TextWatcher() {
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
                    int R25=Integer.parseInt(stu1R5.getText().toString());
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
        stu3R5.addTextChangedListener(textWatcher2);




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
                    student1La1marks.put("LA1",finalmarksstud1);

                    mRootRef.child("Marks").child(stud1n).setValue(student1La1marks)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Assignmarksise.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Assignmarksise.this,navActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Assignmarksise.this, " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });


                    // for stud2
                    Map<String, String> student2La1marks = new HashMap<String, String>();
                    student2La1marks.put("LA1",finalmarksstud2);

                    mRootRef.child("Marks").child(stud2n).setValue(student2La1marks)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Assignmarksise.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Assignmarksise.this,navActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Assignmarksise.this, " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });



                    // for stud 3
                    Map<String, String> student3La1marks = new HashMap<String, String>();
                    student3La1marks.put("LA1",finalmarksstud3);

                    mRootRef.child("Marks").child(stud3n).setValue(student3La1marks)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Assignmarksise.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Assignmarksise.this,navActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Assignmarksise.this, " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });



                }
               }

           });
    }
}