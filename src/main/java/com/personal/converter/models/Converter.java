package com.personal.converter.models;


public abstract class Converter {
    private Measurement input;
    private Measurement output;

    private double equivalence;


    public abstract String getEquivalenceMsg();

    public abstract String getResultMsg();

    public abstract void setEquivalence(String from, String to);

    public void setEquivalence(double value){
        this.equivalence = value;
    }

    public void convert(){
        this.output.setValue(this.input.getValue() * this.equivalence);
    }

    public void initInOut(Measurement m){
        this.input = new Measurement(m.getId(), m.getSymbol(), m.getId());
        this.output = new Measurement(m.getId(), m.getSymbol(), m.getId());
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
