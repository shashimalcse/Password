package com.example.myapplication;

import java.util.ArrayList;

public class SpinFour extends Spin {
    final int Degree;
    final ArrayList<String> Fruits;
    final ArrayList<String> Colors;
    final int ColorRing;
    final int FruitRing;

    public SpinFour() {
        Degree=90;


        FruitRing = R.drawable.colorfour;
        ColorRing = R.drawable.fruitfour;



        Fruits = new ArrayList<>();
        Fruits.add("apple");
        Fruits.add("banana");
        Fruits.add("orange");
        Fruits.add("mango");

        Colors = new ArrayList<>();
        Colors.add("blue");
        Colors.add("yellow");
        Colors.add("green");
        Colors.add("red");

    }

    public int getDegree() {
        return Degree;
    }

    public ArrayList<String> getFruits() {
        return Fruits;
    }
    public ArrayList<String> getColors() {
        return Colors;
    }
}
