package com.personal.converter.models;

public class Measurement {
    private String id;
    private String symbol;
    private String name;
    private double value;
    private String imgPath;

    public Measurement(){

    }

    public Measurement(String id, String symbol, String name, String imgPath){
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.imgPath = imgPath;
    }

    public Measurement(String id, String symbol, String name){
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

    public String getSymbol(){
        return symbol;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
}
