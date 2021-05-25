package com.example.e_assess;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText mail;
    private EditText pwd;
    private Button login;
    public static final String EXTRA_NAME = "com.example.e_assess.extra.NAME";
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        mail = findViewById(R.id.emaillg);
        pwd = findViewById(R.id.pwdlg);
        login = findViewById(R.id.loginid);

        auth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = mail.getText().toString();
                String txt_password = pwd.getText().toString();

                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)){
                    Toast.makeText(LoginActivity.this, "Empty Credentials!", Toast.LENGTH_SHORT).show();
                } else {
                    loginUser(txt_email , txt_password);
                }
            }
        });
    }

    private void loginUser(String mail, String pwd){
         auth.signInWithEmailAndPassword(mail,pwd).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
             @Override
             public void onSuccess(AuthResult authResult) {
                 Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(LoginActivity.this,navActivity.class);
                 intent.putExtra(EXTRA_NAME,mail);
                 startActivity(intent);
                 finish();
             }
         });
    }

}