package com.example.anirudh.moovengroove.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anirudh.moovengroove.ActivityDetection.UserActivity;
import com.example.anirudh.moovengroove.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText uName,pwd;
    TextView sgnUp;
    Button login;
    public FirebaseAuth myAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViewgroup();

        mAuthListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                    if(user!=null){

                    }
            }
        };
        onCLick();

    }
    private void initViewgroup(){
        uName=(EditText)findViewById(R.id.userName);
        pwd=(EditText)findViewById(R.id.password);
        sgnUp=(TextView)findViewById(R.id.newsignup);
        login=(Button)findViewById(R.id.login);
        myAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
    }
    public void onCLick(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAuth.signInWithEmailAndPassword(uName.getText().toString(),pwd.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                                Toast.makeText(LoginActivity.this,"Enter Correct Email and Password",Toast.LENGTH_SHORT).show();
                            else {
                                Toast.makeText(LoginActivity.this," SIgned in",Toast.LENGTH_SHORT).show();
                                Intent usrActInt=new Intent(LoginActivity.this,UserActivity.class);
                                usrActInt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(usrActInt);
                                }
                            }
                        });
            }
        });
        sgnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("", "onClick: ");
                Intent signUp=new Intent(getApplicationContext(),Signup.class);
                startActivity(signUp);
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        myAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            myAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
