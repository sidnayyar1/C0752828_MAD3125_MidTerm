package com.LambtonCollege.c0752828_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edtEmail;
    EditText edtPassword;
    Button btnLogin;
    UserData u1 = new UserData("Sid@gmail.com","sid123");
    UserData u2 = new UserData("Rohit@gmail.com","Rohit123");
    UserData u3 = new UserData("Rahul@gmail.com","Rahul123");
    UserData u4 = new UserData("vikas@gmail.com","vikas123");
    UserData u5 = new UserData("viney@gmail.com","vinay123");
    UserData userData[] = {u1,u2,u3,u4,u5};
SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        sharedPreferences = getSharedPreferences("userDetails",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = edtEmail.getText().toString();
                String Password = edtPassword.getText().toString();
                for (int i = 0;i<userData.length;i++){
                    if (Email.equals(userData[i].getEmail()) && Password.equals(userData[i].getPassword())){
                       editor.putString("email",Email);
                       editor.putString("password",Password);
                       editor.apply();
                        Intent toLogin = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(toLogin);
                    }else {

                        Toast.makeText(LoginActivity.this,"Incorrect email or password",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }

}
