package com.example.e_assess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileAdmin extends AppCompatActivity {
    private FirebaseUser user;
    TextView txtmailshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_admin);

        user = FirebaseAuth.getInstance().getCurrentUser();
        String mailid = user.getEmail().toString();
        txtmailshow = findViewById(R.id.showmail);
        txtmailshow.setText(mailid);




    }
}