package com.example.myapplication;

import java.util.ArrayList;

public abstract class Spin {

    private int Degree;
    private ArrayList<String> Fruits;
    private ArrayList<String> Colors;
    private int ColorRing;
    private int FruitRing;


    public int getDegree(){
        return Degree;
    };

    public ArrayList<String> getFruits() {
        return Fruits;
    }
    public ArrayList<String> getColors() {
        return Colors;
    }

    public int getColorRing() {
        return ColorRing;
    }

    public int getFruitRing() {
        return FruitRing;
    }
}
