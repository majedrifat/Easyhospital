package com.majedul.easyHospital.Activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.majedul.easyHospital.R;

public class LoginActivity extends AppCompatActivity {
    private EditText userEmail;
    private EditText password;
    private Button loginBtn;

    private TextView forgotPass;
    private TextView signUp;
    private static String PASS = "tsrsyatsdhf566";
    private SharedPreferences userPreference;
    private SharedPreferences.Editor editor;

    private SharePrefarence sharePreferenCls;
    private AlertDialog.Builder customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = (EditText)findViewById(R.id.user_email);
        password = (EditText)findViewById(R.id.user_pass);
        loginBtn = (Button)findViewById(R.id.login_btn);
        // forgotPass = (TextView)findViewById(R.id.forgot_pass);
        signUp = (TextView)findViewById(R.id.signup);
        customDialog = new AlertDialog.Builder(this);
        sharePreferenCls = new SharePrefarence(this);
        /*if (PASS.equals("tsrsyatsdhf566")){
            sharePreferenCls.saveUser(null,PASS,null,null,false);
            PASS=null;
        }*/
    }

    public void createNew(View view) {
        startActivity(new Intent(this,Singup.class));
    }

    public void LogIn(View view) {
        String userMail = userEmail.getText().toString();
        String userPassword = password.getText().toString();
        if (userMail.equals(sharePreferenCls.getUserMail()) && userPassword.equals(sharePreferenCls.getUserPass())){
            sharePreferenCls.saveUser(userMail,userPassword,true);
            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
        }else{
            Toast.makeText(this, "Email or password not correct!", Toast.LENGTH_SHORT).show();
        }
    }

    /*public void ForgotPass(View view) {
        final TextView question = new TextView(this);
        question.setText(sharePreferenCls.getUserQuestion());
        customDialog.setTitle("Answer the question");
        customDialog.setView(question);

        final EditText answer = new EditText(this);
        answer.setHint("Your answer");
        customDialog.setView(answer);
        customDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String ans = answer.getText().toString().toLowerCase();
                String s  = sharePreferenCls.getUserAnswer();
                if (ans.equals(s)){
                    startActivity(new Intent(Login.this,signup.class));
                }else {
                    Toast.makeText(Login.this, "Your answer is not correct!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        customDialog.setNegativeButton("Cancel",null);
        customDialog.show();
    }*/

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

//    EditText pinET;
//    Button enterBtn;
//
//    //This is my login page
//    //another to try commit
//    //hhahahaha added
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        pinET= (EditText) findViewById(R.id.pinET);
//        enterBtn= (Button) findViewById(R.id.enterBtn);
//    }
//
//    public void enter(View view) {
//        if (pinET.getText().toString().equals("12345"))
//        {
//            Toast.makeText(getApplicationContext(),"Pin Is Correct!!!",Toast.LENGTH_LONG).show();
//            Intent intent= new Intent(LoginActivity.this,HomeActivity.class);
//            startActivity(intent);
//        }
//        else {
//            Toast.makeText(getApplicationContext(),"Pin Is Incorrect!!!,Try Again",Toast.LENGTH_LONG).show();
//        }
//    }


