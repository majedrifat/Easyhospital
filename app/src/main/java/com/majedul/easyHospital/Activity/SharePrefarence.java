package com.majedul.easyHospital.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mdmajedul on 5/26/17.
 */

public class SharePrefarence  {
    public static final String USER_AUTHENTICATION = "user_authentication";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_PASS = "user_pass";
    public static final String USER_STATUS = "user_status";
    public static final String USER_QUESTION = "user_question";
    public static final String USER_ANSWER = "user_answer";

    private SharedPreferences userPreference;
    private SharedPreferences.Editor editor;
    private Context context;


    public SharePrefarence(Context context) {
        this.context = context;
        userPreference = context.getSharedPreferences(USER_AUTHENTICATION,Context.MODE_PRIVATE);
        editor = userPreference.edit();
    }

    public void saveUser(String email, String pass, boolean status){
        editor.putString(USER_EMAIL,email);
        editor.putString(USER_PASS,pass);
        editor.putBoolean(USER_STATUS,status);
        editor.commit();
    }

    public String getUserMail(){
        return userPreference.getString(USER_EMAIL,"no such email or password found");
    }
    public String getUserPass(){
        return userPreference.getString(USER_PASS,"no such email or password found");
    }

    public boolean getUserStatus(){
        return userPreference.getBoolean(USER_STATUS,false);
    }



    public void clearUserData(){
        editor.clear();
        editor.commit();
    }
}
