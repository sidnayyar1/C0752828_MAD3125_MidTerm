package com.LambtonCollege.c0752828_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//        try{
//            Thread.sleep(5000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i =new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        },4000);

    }
}
