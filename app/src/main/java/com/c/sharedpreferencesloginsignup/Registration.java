package com.c.sharedpreferencesloginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText edUser,edPhone,edMail,edPass;
    Button btnReg,login;


    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getSupportActionBar().setTitle("Registration Page");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edUser=findViewById(R.id.edUser);
        edPhone=findViewById(R.id.edPhone);
        edMail=findViewById(R.id.edMail);
        edPass=findViewById(R.id.edPass);

        btnReg=findViewById(R.id.btnReg);
        login=findViewById(R.id.login);
        sharedPreferences=getSharedPreferences("Userinfo",0);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //SharedPreferences preferences=getSharedPreferences("Userinfo",MODE_PRIVATE);
                String uvalue=edUser.getText().toString();
                String pvalue=edPhone.getText().toString();
                String mvalue=edMail.getText().toString();
                String passvalue=edPass.getText().toString();


                if(uvalue.length()>1) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", uvalue);
                    editor.putString("phone", pvalue);
                    editor.putString("mail", mvalue);
                    editor.putString("password", passvalue);
                    editor.apply();
                    Toast.makeText(Registration.this, "User Register", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Registration.this, "Enter Value", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Registration.this,Login.class);
                startActivity(intent);
            }
        });


    }
}