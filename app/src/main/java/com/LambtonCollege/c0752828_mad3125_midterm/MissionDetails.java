package com.LambtonCollege.c0752828_mad3125_midterm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MissionDetails extends AppCompatActivity {
    TextView txtName;
    ImageView missionImage;

String image,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_details);

        txtName = (TextView)findViewById(R.id.missionName);
        missionImage = (ImageView)findViewById(R.id.missionIcon);

        Intent i4 = getIntent();
       image =  i4.getStringExtra("image");
       name =  i4.getStringExtra("name");
        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
        //txtName.setText(name);
        Glide.with(this).load(image).into(missionImage);
    }

}
