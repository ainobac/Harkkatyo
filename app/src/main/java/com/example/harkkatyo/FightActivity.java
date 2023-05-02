package com.example.harkkatyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Scanner;

public class FightActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        Button fightBtn = findViewById(R.id.btnFight);
        RadioGroup radioGroup = findViewById(R.id.rgFighters);
        CheckBox checkBox;
        int i = 0;
        for (Lutemon l : Storage.getInstance().getLutemonsFight()) {
            checkBox = new CheckBox(this);
            checkBox.setText(l.getName()+" ("+l.getColor()+")");
            checkBox.setId(i++);
            checkBox.setTag(l);
            radioGroup.addView(checkBox);
        }

        fightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lutemon lutemon1 = null;
                Lutemon lutemon2 = null;
                RadioGroup rgLutemons = findViewById(R.id.rgFighters);

                for(int i = 0; i < rgLutemons.getChildCount(); i++) {
                    CheckBox checkBox = (CheckBox) rgLutemons.getChildAt(i);
                    if (checkBox.isChecked()) {
                        if (lutemon1 == null) {
                            lutemon1 = (Lutemon) checkBox.getTag();
                        } else {
                            lutemon2 = (Lutemon) checkBox.getTag();
                            break;
                        }
                    }
                }

                if (lutemon1 != null && lutemon2 != null) {
                    fight(lutemon1, lutemon2);
                }
            }
        });
    }

    public void fight(Lutemon lut1, Lutemon lut2) {
        Lutemon attacker = lut1;
        Lutemon defender = lut2;
        attacker.setFights(attacker.getFights()+1);
        defender.setFights(defender.getFights()+1);
        int id1 = 1;
        int id2 = 2;
        textView = (TextView) findViewById(R.id.textViewFight);
        textView.setText("");

        while (true) {
            textView.append(id1+": "+attacker.getName()+"("+attacker.getColor()+") att: "+attacker.getAttack()+"; def: "+attacker.getDefence()+"; exp: "+attacker.getExperience()+"; health: "+attacker.getHealth()+"/"+attacker.getMaxHealth()+"\n");
            textView.append(id2+": "+defender.getName()+"("+defender.getColor()+") att: "+ defender.getAttack()+"; def: "+defender.getDefence()+"; exp: "+defender.getExperience()+"; health: "+defender.getHealth()+"/"+defender.getMaxHealth()+"\n");

            attacker.attack(defender);
            textView.append(attacker.getName()+"("+attacker.getColor()+") attacks "+defender.getName()+"("+defender.getColor()+")\n");

            if(checkDeath(defender)) {
                textView.append("The battle is over.");
                attacker.setExperience(attacker.getExperience()+2);
                defender.setHealth(0);
                attacker.setHealth(attacker.getMaxHealth());
                Storage.getInstance().getLutemonsFight().remove(defender);
                Storage.getInstance().getLutemonsDead().add(defender);
                attacker.setWins(attacker.getWins()+1);
                defender.setDeads(defender.getDeads()+1);
                break;
            }
            textView.append(defender.getName()+"("+defender.getColor()+") manages to escape death\n");

            Lutemon def = attacker;
            attacker = defender;
            defender = def;
            int id3 = id1;
            id1 = id2;
            id2 = id3;

            textView.invalidate();
        }
    }

    private boolean checkDeath(Lutemon lutemon) {
        textView = (TextView) findViewById(R.id.textViewFight);
        if(lutemon.getHealth() <= 0) {
            textView.append(lutemon.getName()+"("+lutemon.getColor()+") gets killed.\n");
            return true;
        }
        return false;
    }
}