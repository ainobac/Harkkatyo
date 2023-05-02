package com.example.harkkatyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {
    private ArrayList<Lutemon> lutemons;
    private RadioGroup radioGroupLutemons, radioGroupFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        radioGroupLutemons = findViewById(R.id.rgLutemonsInRest);
        radioGroupFood = findViewById(R.id.radioGroupFoods);

        lutemons = Storage.getInstance().getLutemons();

        int i = 0;
        for (Lutemon lutemon : lutemons) {
            RadioButton radioButton = new RadioButton(RestaurantActivity.this);
            radioButton.setText((lutemon.getName() + " (" + lutemon.getColor() + ")"));
            radioButton.setId(i++);
            radioGroupLutemons.addView(radioButton);
        }
    }

    public void feedLutemon(View view) {
        int lutemonRadioId = radioGroupLutemons.getCheckedRadioButtonId();
        RadioButton lutemonRadioButton = findViewById(lutemonRadioId);
        int lutemonIndex = lutemonRadioButton.getId();
        Lutemon lutemon = lutemons.get(lutemonIndex);

        int foodRadioId = radioGroupFood.getCheckedRadioButtonId();
        RadioButton foodRadioButton = findViewById(foodRadioId);
        String foodName = foodRadioButton.getText().toString();

        int healthChange = 0;
        switch (foodName) {
            case "Hedelmäsalaatti":
                healthChange = 1;
                break;
            case "Suklaakakku":
                healthChange = -1;
                break;
            case "JättiJäätelöannos":
                healthChange = -2;
                break;
            case "Lutemonien vitamiineja":
                healthChange = 2;
                break;
        }
        lutemon.setHealth(lutemon.getHealth() + healthChange);
    }
}