package com.example.harkkatyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class StatisitcsActivity extends AppCompatActivity {

    private TextView textView;
    private ArrayList<Lutemon> lutemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statisitcs);

        textView = (TextView) findViewById(R.id.textViewStats);
        textView.setText("");
        lutemons = Storage.getInstance().getLutemons();

        for (Lutemon l : lutemons) {
            textView.append(l.getName()+"("+l.getColor()+") Taistelut: "+l.getFights()+" Voitot: "+l.getWins()+" Kuolemat: "+l.getDeads()+" Treenit: "+l.getTrainings()+"\n");
        }
    }

}