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

public class FragmentFighting extends Fragment {

    private View view;
    private RadioGroup rgLutemons;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fighting, container, false);

        Button moveBtn = view.findViewById(R.id.buttonMove);
        rgLutemons = view.findViewById(R.id.radioGroupLutemonList);
        rgLutemons.removeAllViews();
        CheckBox checkBox;
        int i = 0;
        for (Lutemon l : Storage.getInstance().getLutemonsFight()) {
            checkBox = new CheckBox(getActivity());
            checkBox.setText(l.getName()+" ("+l.getColor()+")");
            checkBox.setId(i++);
            checkBox.setTag(l);
            rgLutemons.addView(checkBox);
        }
        setRetainInstance(true);
        moveBtn.setOnClickListener(new View.OnClickListener() {
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

        RadioButton btnHome = view.findViewById(R.id.radioButtonHome2);
        RadioButton btnTrain = view.findViewById(R.id.radioButtonTrain2);

        for (int i = 0; i < rgLutemons.getChildCount(); i++) {
            CheckBox checkBox = (CheckBox) rgLutemons.getChildAt(i);
            if (checkBox.isChecked()) {
                Lutemon l = (Lutemon) checkBox.getTag();
                lutemonsFight.remove(l);
                if (btnTrain.isChecked()) {
                    lutemonsTrain.add(l);
                }
                if (btnHome.isChecked()) {
                    lutemonsHome.add(l);
                }
            }
        }

    }
}