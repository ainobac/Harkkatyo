package com.example.harkkatyo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView name, attack, defence, life, experience;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        name = itemView.findViewById(R.id.textViewName);
        attack = itemView.findViewById(R.id.textViewAttack);
        defence = itemView.findViewById(R.id.textViewDefence);
        life = itemView.findViewById(R.id.textViewLife);
        experience = itemView.findViewById(R.id.textViewExperience);
    }

}