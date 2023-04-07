package com.example.prototype;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Liquids extends Product{

    public Liquids(String name, ArrayList<Double> minerals, ArrayList<Double> vitamins) {
        super(name, minerals, vitamins);
    }

    public String toString(){
        return(name+"  "+quantity+"ml");
    }
}
