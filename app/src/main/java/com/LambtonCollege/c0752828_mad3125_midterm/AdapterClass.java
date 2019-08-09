package com.LambtonCollege.c0752828_mad3125_midterm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {
    Context context;
    ArrayList<MissionModel>arrayList;
    public AdapterClass(Context context,ArrayList<MissionModel>arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View ItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);
       return new MyViewHolder(ItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     final  MissionDetails missionDetails;
        final MissionModel missionModel = arrayList.get(position);
//        holder.image1.setImageResource(Integer.parseInt(String.valueOf(missionModel.getImage())));
        Glide.with(context).load(missionModel.getImage()).into(holder.image1);
        holder.name.setText(missionModel.getName());
        holder.launchYear.setText(missionModel.getLaunchYear());
        holder.CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(context,MissionDetails.class);
                i3.putExtra("image",missionModel.getImage());
                i3.putExtra("name",missionModel.getName());
                context.startActivity(i3);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        CardView CardView;
        ImageView image1;
    TextView name;
    TextView launchYear;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = (ImageView)itemView.findViewById(R.id.missileImage);
            name = (TextView)itemView.findViewById(R.id.missionName);
            launchYear = (TextView)itemView.findViewById(R.id.launchYear);
        CardView = (CardView)itemView.findViewById(R.id.myCardview);

        }
    }
}
