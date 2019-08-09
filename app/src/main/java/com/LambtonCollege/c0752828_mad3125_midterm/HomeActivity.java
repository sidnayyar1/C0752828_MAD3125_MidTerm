package com.LambtonCollege.c0752828_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
ArrayList<MissionModel> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        processJSON();
    }
    private void processJSON()
    {
        String jsonString = this.loadJSONFromAsset();
        if(jsonString != null)
        {
            try
            {
                JSONArray mJSONArray = new JSONArray(jsonString);
                arrayList = new ArrayList<>();

                Log.d("check",jsonString);
                for(int i = 0; i < mJSONArray.length(); i++)
                {

                    MissionModel mm = this.getUserObjectFromJSON(mJSONArray.getJSONObject(i));
                    arrayList.add(mm);
                    Log.d("-- JSON -- ", mm.toString());

                    /*
                    JSONObject mJSONObject = mJSONArray.getJSONObject(i);

                    if(mJSONObject.has("id"))
                    {
                        int id = mJSONObject.getInt("id");
                    }

                    String name = mJSONObject.getString("name");

                    Log.d("-- JSON -- ", name);

                    //Read Address JSON Object
                    JSONObject mAddress = mJSONObject.getJSONObject("address");

                    String city = mAddress.getString("city");
                    Log.d("-- JSON -- ", name + " : " + city);
                    */
                }


            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }

        }
    }
    private MissionModel getUserObjectFromJSON(JSONObject userJsonObject) throws JSONException
    {

        String name = userJsonObject.getString("mission_name");
        String launch = userJsonObject.getString("launch_year");


        //Read User Address
        JSONObject address = new JSONObject(userJsonObject.getJSONObject("links").toString());
        String image = address.getString("mission_patch");
        //start creating User object
        MissionModel mM = new MissionModel();
        mM.setName(name);
        mM.setLaunchYear(launch);
        mM.setImage(image);

        return mM;

    }
    private String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("Missions.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            int count = is.read(buffer);
            is.close();
            Log.d("-- COUNT --", String.format("%d Bytes",count));
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}