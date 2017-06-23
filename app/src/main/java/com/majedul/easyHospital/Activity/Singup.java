package com.majedul.easyHospital.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.majedul.easyHospital.R;

public class Singup extends AppCompatActivity {

    private EditText userName;
    private EditText userEmail;
    private EditText question;
    private EditText answer;
    private EditText password;
    private EditText confirmPassword;
    private Button signInBtn;

    private SharedPreferences userPreference;
    private SharedPreferences.Editor editor;

    private SharePrefarence sharePreferenCls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        userName = (EditText)findViewById(R.id.user_name);
        userEmail = (EditText)findViewById(R.id.email);
       /* question = (EditText)findViewById(R.id.question);
        answer = (EditText)findViewById(R.id.answer);*/
        password = (EditText)findViewById(R.id.password);
        confirmPassword=(EditText)findViewById(R.id.confirm_pass);
        signInBtn = (Button)findViewById(R.id.sign_up);

        sharePreferenCls = new SharePrefarence(this);
    }


    public void SignUp(View view) {
        String email = userEmail.getText().toString();
        String pass = password.getText().toString();/*
        String ques = question.getText().toString();
        String ans = answer.getText().toString().toLowerCase();*/
        String confirmPass = confirmPassword.getText().toString();

        if(email.isEmpty()){
            userEmail.setError("This field must not be empty");
        }else if(pass.isEmpty()){
            password.setError("This field must not be empty");
        }else if(confirmPass.isEmpty()){
            confirmPassword.setError("This field must not be empty");
        }else {
            if (pass.equals(confirmPass)){
                sharePreferenCls.saveUser(email,pass,true);
                startActivity(new Intent(Singup.this,HomeActivity.class));
                Toast.makeText(this,""+pass, Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Password not match!", Toast.LENGTH_SHORT).show();
            }

        }

    }


}
