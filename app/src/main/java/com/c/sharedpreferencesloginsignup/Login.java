package com.c.sharedpreferencesloginsignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText gMail,passWord;
    Button loGin;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login Page");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gMail=findViewById(R.id.gMail);
        passWord=findViewById(R.id.passWord);
        loGin=findViewById(R.id.loGin);
        sharedPreferences=getSharedPreferences("Userinfo",0);

        loGin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gvalue=gMail.getText().toString();
                String pvalue=passWord.getText().toString();


                String registerusername=sharedPreferences.getString("mail","");
                String registerpassword=sharedPreferences.getString("password","");


                if(gvalue.equals(registerusername) && pvalue.equals(registerpassword)){
                    Intent intent=new Intent(Login.this,welcomeLogin.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(Login.this, "Something Wrong", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}