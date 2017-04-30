package com.example.anirudh.moovengroove.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anirudh.moovengroove.ActivityDetection.UserActivity;
import com.example.anirudh.moovengroove.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    EditText fName,lName,email,pswrd;
    Button signup;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    ProgressDialog progressDialog;
    private DatabaseReference userDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_signup);
        initViewgroup();
        onClick();
    }
    private void initViewgroup(){
        fName=(EditText)findViewById(R.id.fName);
        lName=(EditText)findViewById(R.id.lName);
        pswrd=(EditText)findViewById(R.id.newPassword);
        email=(EditText) findViewById(R.id.emailID);
        signup=(Button)findViewById(R.id.signUp);
        mAuth=FirebaseAuth.getInstance();
        userDb= FirebaseDatabase.getInstance().getReference().child("Users");
    }
    private void onClick(){
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("signupClicked", "onClick: ");
                String emailID=email.getText().toString();
                String password=pswrd.getText().toString();
                final String firName=fName.getText().toString().trim();
                final String lasName=lName.getText().toString().trim();
                if(TextUtils.isEmpty(emailID)&&TextUtils.isEmpty(password)){
                    Toast.makeText(Signup.this,"Fields EMpty",Toast.LENGTH_SHORT).show();
                    Log.d("signupClicked", "EmptyClick: ");
                }
                else{
                    mAuth.createUserWithEmailAndPassword(emailID,password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(!task.isSuccessful())
                                        Toast.makeText(Signup.this,"Problem Signing UP",Toast.LENGTH_SHORT).show();
                                    else {
                                                Thread signupThread=new Thread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                    Log.d("runSignup", "run: ");
                                                    String userID=mAuth.getCurrentUser().getUid();
                                                    DatabaseReference currentUserDb=userDb.child(userID);
                                                    currentUserDb.child("First Name").setValue(firName);
                                                    currentUserDb.child("Last Name").setValue(lasName);
                                                        Intent userActIntent=new Intent(Signup.this, UserActivity.class);
                                                        startActivity(userActIntent);
                                                    }
                                                });
                                        signupThread.start();
                                    }



                                }
                            });
                }


            }
        });
    }

}
