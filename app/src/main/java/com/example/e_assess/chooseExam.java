package com.example.e_assess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class chooseExam extends AppCompatActivity {

      String student1,student2,student3;
    String c = "palak";
    TextView txt1,txt2,txt3,txt4;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_exam);
      // s1.set
       // Toast.makeText(this, getIntent().getStringExtra("stud1name"), Toast.LENGTH_SHORT).show();


        txt1 = findViewById(R.id.txtise1);
        txt2 = findViewById(R.id.txtise2);
        txt3 = findViewById(R.id.txtmse);
        txt4 = findViewById(R.id.txtese);

        student1 =getIntent().getStringExtra("stud1name").toString();
        student2 =getIntent().getStringExtra("stud2name").toString();
        student3 =getIntent().getStringExtra("stud3name").toString();
        Log.i("stud1",student1);
        Log.i("stud1",student2);
        Log.i("stud1",student3);
        Log.i("ohhh",c);


        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(chooseExam.this, Assignmarksise.class);
                intent.putExtra("stud1name",student1);
                intent.putExtra("stud2name",student2);
                intent.putExtra("stud3name",student3);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseExam.this, Ise2.class);
                intent.putExtra("stud1name",student1);
                intent.putExtra("stud2name",student2);
                intent.putExtra("stud3name",student3);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseExam.this, Mse.class);
                intent.putExtra("stud1name",student1);
                intent.putExtra("stud2name",student2);
                intent.putExtra("stud3name",student3);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseExam.this, Ese.class);
                intent.putExtra("stud1name",student1);
                intent.putExtra("stud2name",student2);
                intent.putExtra("stud3name",student3);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}