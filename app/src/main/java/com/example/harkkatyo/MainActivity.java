package com.example.harkkatyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchToCreateLutemon(View view) {
        Intent intent = new Intent(this, AddNewLutemon.class);
        startActivity(intent);
    }

    public void switchToListLutemon(View view) {
        Intent intent = new Intent(this, ListLutemonsActivity.class);
        startActivity(intent);
    }

    public void switchToFragments(View view) {
        Intent intent = new Intent(this, TabActivity.class);
        startActivity(intent);
    }

    public void switchToRestaurant(View view) {
        Intent intent = new Intent(this, RestaurantActivity.class);
        startActivity(intent);
    }

    public void switchToFightArena(View view) {
        Intent intent = new Intent(this, FightActivity.class);
        startActivity(intent);
    }

    public void switchToStatistics(View view) {
        Intent intent = new Intent(this, StatisitcsActivity.class);
        startActivity(intent);
    }

}