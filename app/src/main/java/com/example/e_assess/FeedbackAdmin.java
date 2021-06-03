package com.example.e_assess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FeedbackAdmin extends AppCompatActivity {
    private FirebaseUser user;
    EditText fromid;
    EditText msg;
    Button btn;
    String toid = "pashk.firebase11@gmail.com";
    String subject = "Feedback";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_admin);

        btn = findViewById(R.id.send);
        msg = findViewById(R.id.editTextTextMultiLine);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user = FirebaseAuth.getInstance().getCurrentUser();
                String mailfrom = user.getEmail().toString();
                String  mailto = "pashk.firebase11@gmail.com";
                String subject = "Feedback";
                String mailbody = msg.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{mailto});
                email.putExtra(Intent.EXTRA_SUBJECT,subject);
                email.putExtra(Intent.EXTRA_TEXT,mailbody);

                email.setType("mailbody/rfc822");
                startActivity(Intent.createChooser(email,"choose an email client"));

            }
        });

    }
}