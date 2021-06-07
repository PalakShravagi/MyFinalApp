package com.example.e_assess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
  private EditText email;
    private EditText password;
    private Button register;
    private EditText post;
    private EditText classcode;
    private FirebaseAuth auth;
    private EditText name;
    private DatabaseReference mRootRef;
    public static final String EXTRA_NAME = "com.example.e_assess.extra.NAME";
public ProgressBar progressBr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        password = findViewById(R.id.idpassword);
        post = findViewById(R.id.post);
        classcode = findViewById(R.id.clcode);
        register = findViewById(R.id.idregister);
        name = findViewById(R.id.name);


        auth = FirebaseAuth.getInstance();
        mRootRef = FirebaseDatabase.getInstance().getReference();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtEmail = email.getText().toString();
                String txtPassword = password.getText().toString();
                String txtpost = post.getText().toString().toUpperCase();
                String txtcode = classcode.getText().toString().toUpperCase();
                String txtname = name.getText().toString().toUpperCase();

                if (TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)||TextUtils.isEmpty(txtpost)||TextUtils.isEmpty(txtcode)||TextUtils.isEmpty(txtname)  ){
                    Toast.makeText(RegisterActivity.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                } else if (txtPassword.length() < 6){
                    Toast.makeText(RegisterActivity.this, "Password too short!", Toast.LENGTH_SHORT).show();
                } else {
                    if(txtpost.equals("ADMIN")){
                    registerUser( txtname,txtEmail , txtPassword , txtcode,txtpost);
                    }
                    else if(txtpost.equals("GUIDE")) {
                        registerUser( txtname,txtEmail , txtPassword , txtcode,txtpost);
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Enter Admin or Guide ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
/*
    private void registerUser(String email, String password ,String code ,String post) {
          auth.createUserWithEmailAndPassword(email,password,code,post).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                  if(task.isSuccessful()){
                      Toast.makeText(RegisterActivity.this, "Register Succesfully!", Toast.LENGTH_SHORT).show();
                      startActivity(new Intent(RegisterActivity.this,navActivity.class));
                      finish();
                  }
                  else{
                      Toast.makeText(RegisterActivity.this, "Registration failed!", Toast.LENGTH_SHORT).show();
                  }
              }
          });
    }

*/
    private void registerUser(String name ,String email, String password ,String code ,String post) {

        auth.createUserWithEmailAndPassword(email , password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                HashMap<String , Object> map = new HashMap<>();
                    map.put("code" , code);
                    map.put("post", post);
                    map.put("name",name);

                mRootRef.child("Users").child(auth.getCurrentUser().getUid()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            if(post.equals("admin") || post.equals("Admin") || post.equals("ADMIN")||post.equals("Guide") || post.equals("guide") || post.equals("GUIDE")){

                                auth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            auth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    progressBr = findViewById(R.id.regprogressbar);
                                                    progressBr.setVisibility(View.VISIBLE);
                                                    if(task.isSuccessful()){
                                                        Toast.makeText(RegisterActivity.this, "Register Succesfully! Please verify your email ID !!", Toast.LENGTH_SHORT).show();
                                                        Intent intent = new Intent(RegisterActivity.this,choiceActivity.class);
                                                        startActivity(intent);
                                                        finish();
                                                    }
                                                    else{
                                                        Toast.makeText(RegisterActivity.this, "Register Succesfully! Please verify your email ID !!", Toast.LENGTH_SHORT).show();
                                                        Intent intent = new Intent(RegisterActivity.this,choiceActivity.class);
                                                        startActivity(intent);
                                                        finish();
                                                    }
                                                }
                                            });

                                        }
                                    }
                                });
                            }
                            else{
                                Toast.makeText(RegisterActivity.this, "Enter Admin/Guide ", Toast.LENGTH_SHORT).show();
                                progressBr = findViewById(R.id.regprogressbar);
                                progressBr.setVisibility(View.INVISIBLE);
                            }

                        }
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}













