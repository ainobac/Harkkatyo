package com.example.harkkatyo;

import java.io.Serializable;

public class Lutemon implements Serializable {

    protected String name;
    protected String color;
    protected int attack;
    protected int defense;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int fights;
    protected int deads;
    protected int wins;
    protected int trainings;
    protected int image;


    public Lutemon(String name, String color, int attack, int defense, int experience, int health, int maxHealth, int fights, int deads, int wins, int trainings, int image) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.fights = fights;
        this.deads = deads;
        this.wins = wins;
        this.trainings = trainings;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defense;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getFights() {
        return fights;
    }

    public int getDeads() {
        return deads;
    }

    public int getWins() {
        return wins;
    }

    public int getTrainings() {
        return trainings;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setFights(int fights) {
        this.fights = fights;
    }

    public void setDeads(int deads) {
        this.deads = deads;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setTrainings(int trainings) {
        this.trainings = trainings;
    }

    public void attack(Lutemon opponent) {
        int damage = this.attack+this.experience - opponent.getDefence();
        if (damage < 0) {
            damage = 0;
        }
        opponent.setHealth(opponent.getHealth()-damage);
    }

    public int getImage() {return image;}
}

