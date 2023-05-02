package com.example.harkkatyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddNewLutemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void createLutemon(View view) {

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        EditText name = findViewById(R.id.editTextLutemonName);
        String name2 =  name.getText().toString();
        int image = 0;


        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radioButtonWhite:
                image = R.drawable.imgwhite;
                Storage.getInstance().addLutemon(new White(name2, image));

                break;
            case R.id.radioButtonGreen:
                image = R.drawable.imggreen;
                Storage.getInstance().addLutemon(new Green(name2, image));
                break;
            case R.id.radioButtonPink:
                image = R.drawable.imgpink;
                Storage.getInstance().addLutemon(new Pink(name2, image));
                break;
            case R.id.radioButtonOrange:
                image = R.drawable.imgorange;
                Storage.getInstance().addLutemon(new Orange(name2, image));
                break;
            case R.id.radioButtonBlack:
                image = R.drawable.imgblack;
                Storage.getInstance().addLutemon(new Black(name2, image));
                break;
        }
    }
}