package com.example.e_assess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class FeedbackAct extends AppCompatActivity {
    EditText fromid;
    EditText msg;
    Button btn;
    String toid = "pashk.firebase11@gmail.com";
    String subject = "Feedback";
    FirebaseDatabase fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        /* btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 fromid = findViewById(R.id.editTextTextEmailAddress);
                 msg = findViewById(R.id.editTextTextMultiLine);
                 btn = findViewById(R.id.send);
                 if (TextUtils.isEmpty((CharSequence) fromid) || TextUtils.isEmpty((CharSequence) msg)){
                     Toast.makeText(FeedbackAct.this, "Empty Credentials!", Toast.LENGTH_SHORT).show();
                 }

             }
         });
    }*/
    }

}
