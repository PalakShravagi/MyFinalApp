package com.example.e_assess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
   EditText email ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         email = findViewById(R.id.editTextTextEmailAddress);

        setContentView(R.layout.activity_main2);
        Toast.makeText(this, "Firebase connection successful.!!", Toast.LENGTH_SHORT).show();

    }
    public void newActivity(View v){
        Intent intent = new Intent(LoginActivity.this, navActivity.class);
        startActivity(intent);
    }
}