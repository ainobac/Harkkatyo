package com.example.harkkatyo;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class Storage {

    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private ArrayList<Lutemon> lutemonsHome = new ArrayList<>();
    private ArrayList<Lutemon> lutemonsTrain = new ArrayList<>();
    private ArrayList<Lutemon> lutemonsFight = new ArrayList<>();
    private ArrayList<Lutemon> lutemonsDead = new ArrayList<>();
    private static Storage storage = null;

    private Storage() {
    }

    public static Storage getInstance() {
        if(storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public ArrayList<Lutemon> getLutemons() {
        return  lutemons;
    }
    public ArrayList<Lutemon> getLutemonsHome() {
        return  lutemonsHome;
    }
    public ArrayList<Lutemon> getLutemonsTrain() {
        return  lutemonsTrain;
    }
    public ArrayList<Lutemon> getLutemonsFight() {
        return  lutemonsFight;
    }
    public ArrayList<Lutemon> getLutemonsDead() {
        return  lutemonsDead;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
        lutemonsHome.add(lutemon);
    }

}
