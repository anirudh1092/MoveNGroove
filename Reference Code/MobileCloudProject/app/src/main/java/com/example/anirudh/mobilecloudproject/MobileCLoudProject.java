package com.example.anirudh.mobilecloudproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Handler;

public class MobileCLoudProject extends AppCompatActivity {
    EditText username,passWord;
    Button login;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_cloud_project);
        initializeViewGroup();
        onClick();
    }
    /*
    * This Method is used to initialize all the elements of the view group
    * */
    public void initializeViewGroup(){
        username=(EditText)findViewById(R.id.textUseName);
        passWord=(EditText)findViewById(R.id.textPassword);
        login=(Button)findViewById(R.id.Login);
        signup=(TextView)findViewById(R.id.signup);
    }/*
    * This Method is used to set the Action on Login and SignUp on click
    */
    private void onClick(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable name=username.getText();
                Intent signupActivity=new Intent(getApplicationContext(),SignUp.class);
                startActivity(signupActivity);
            }
        });
       signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Pressed sIGNup Button",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
