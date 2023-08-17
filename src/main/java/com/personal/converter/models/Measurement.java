package com.personal.converter.models;

public class Measurement {
    private String id;
    private char symbol;
    private String name;
    private double value;
    private String imgPath;

    public Measurement(){

    }

    public Measurement(String id,char symbol, String name, String imgPath){
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.imgPath = imgPath;
    }

    public Measurement(String id,char symbol, String name){
        this.id = id;
        this.symbol = symbol;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getValue(){
        return value;
    }

    public void setValue(double value){
        this.value = value;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getImgPath(){
        return imgPath;
    }

    public char getSymbol(){
        return symbol;
    }

    public void setSymbol(char symbol){
        this.symbol = symbol;
    }
}
