package com.personal.converter.models;

public abstract class Converter {
    private Measurement input;
    private Measurement output;

    private double equivalence;


    public abstract String getEquivalenceMsg();

    public abstract String getResultMsg();

    public abstract void setEquivalence(String from, String to);


    public void convert(){
        this.output.setValue(this.input.getValue() * this.equivalence);
    }

    //input and output both have the same values from a ComboBox when the app starts
    public void setInOut(Measurement m){
        this.input = new Measurement(m.getId(), m.getSymbol(), m.getId());
        this.output = new Measurement(m.getId(), m.getSymbol(), m.getId());
    }

    public void setEquivalence(double value){
        this.equivalence = value;
    }

    public Measurement getInput(){
        return input;
    }

    public Measurement getOutput(){
        return output;
    }

    public double getEquivalence(){
        return equivalence;
    }

}
