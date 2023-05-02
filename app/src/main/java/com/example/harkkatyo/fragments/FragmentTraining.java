package com.example.harkkatyo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.harkkatyo.Lutemon;
import com.example.harkkatyo.R;
import com.example.harkkatyo.Storage;

import java.util.ArrayList;

public class FragmentTraining extends Fragment {
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_training, container, false);


        RadioGroup rgLutemons = view.findViewById(R.id.rgTrain);
        RadioGroup rgMove = view.findViewById(R.id.rgLutemonsMove);
        Button btnTrain = view.findViewById(R.id.buttonTrain);
        Button btnMove = view.findViewById(R.id.buttonMove2);

        rgLutemons.removeAllViews();
        RadioButton radioButton;
        int i = 0;
        for (Lutemon l : Storage.getInstance().getLutemonsTrain()) {
            radioButton = new RadioButton(getActivity());
            radioButton.setText(l.getName()+" ("+l.getColor()+")");
            radioButton.setId(i++);
            radioButton.setTag(l);
            rgLutemons.addView(radioButton);
        }
        setRetainInstance(true);
        btnTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                train();
            }
        });

        rgMove.removeAllViews();
        CheckBox checkBox;
        int j = 0;
        for (Lutemon l : Storage.getInstance().getLutemonsTrain()) {
            checkBox = new CheckBox(getActivity());
            checkBox.setText(l.getName()+" ("+l.getColor()+")");
            checkBox.setId(i++);
            checkBox.setTag(l);
            rgMove.addView(checkBox);
        }
        setRetainInstance(true);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveLutemons();
            }
        });

        return view;
    }

    public void moveLutemons() {
        ArrayList<Lutemon> lutemonsHome = Storage.getInstance().getLutemonsHome();
        ArrayList<Lutemon> lutemonsTrain = Storage.getInstance().getLutemonsTrain();
        ArrayList<Lutemon> lutemonsFight = Storage.getInstance().getLutemonsFight();

        RadioGroup rgLutemons = view.findViewById(R.id.rgLutemonsMove);
        RadioButton btnHome = view.findViewById(R.id.radioButtonHome);
        RadioButton btnFight = view.findViewById(R.id.radioButtonFight2);

        for (int i = 0; i < rgLutemons.getChildCount(); i++) {
            CheckBox checkBox = (CheckBox) rgLutemons.getChildAt(i);
            if (checkBox.isChecked()) {
                Lutemon l = (Lutemon) checkBox.getTag();
                lutemonsTrain.remove(l);
                if (btnHome.isChecked()) {
                    lutemonsHome.add(l);
                }
                if (btnFight.isChecked()) {
                    lutemonsFight.add(l);
                }
            }
        }

    }

    public void train() {
        RadioGroup rgLutemons = view.findViewById(R.id.rgTrain);

        for (int i = 0; i < rgLutemons.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) rgLutemons.getChildAt(i);
            if (radioButton.isChecked()) {
                Lutemon l = (Lutemon) radioButton.getTag();
                l.setExperience(l.getExperience()+2);
                l.setTrainings(l.getTrainings()+1);
            }
        }

    }
}