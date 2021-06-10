package com.example.e_assess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Choosestudent extends AppCompatActivity {

    String student1,student2,student3;
    String c = "palak";

    TextView stud1,stud2,stud3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_student);
        // s1.set
        // Toast.makeText(this, getIntent().getStringExtra("stud1name"), Toast.LENGTH_SHORT).show();





        student1 =getIntent().getStringExtra("stud11name").toString();
        student2 =getIntent().getStringExtra("stud22name").toString();
        student3 =getIntent().getStringExtra("stud33name").toString();
        Log.i("stud1",student1);
        Log.i("stud1",student2);
        Log.i("stud1",student3);
        Log.i("ohhh",c);
        stud1 = findViewById(R.id.txtstu1);
        stud2 = findViewById(R.id.txtstu2);
        stud3 = findViewById(R.id.txtstu3);
        stud1.setText(getIntent().getStringExtra("stud11name"));
        stud2.setText(getIntent().getStringExtra("stud22name"));
        stud3.setText(getIntent().getStringExtra("stud33name"));
        //final String stud1n = getIntent().getStringExtra("stud1name").toString();
        //final String stud2n = getIntent().getStringExtra("stud2name").toString();
        //final String stud3n = getIntent().getStringExtra("stud3name").toString();


        stud1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choosestudent.this, navActivity.class);
                intent.putExtra("stud1name",student1);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        stud2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choosestudent.this, navActivity.class);

                intent.putExtra("stud2name",student2);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        stud3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Choosestudent.this, navActivity.class);

                intent.putExtra("stud3name",student3);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


    }
}