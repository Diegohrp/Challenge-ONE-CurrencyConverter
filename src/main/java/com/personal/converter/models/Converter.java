package com.personal.converter.models;

import com.personal.converter.enums.Coins;

public class Converter {
    private final Measurement input;
    private final Measurement output;

    private double equivalence;

    Converter(String id,String symbol, String name){
        this.input = new Measurement(id,symbol,name);
        this.output = new Measurement(id,symbol,name);
    }
    public void convert(){
        this.output.setValue(this.input.getValue() * this.equivalence);
    }

    public String getEquivalenceMsg(){
        return this.getInput().getSymbol()+" 1 "+
            this.getInput().getId()+" = "+ this.getOutput().getSymbol()+
            " "+this.getEquivalence()+ " "+this.getOutput().getId();
    }

    public String getResultMsg(){
        return Double.toString(this.getOutput().getValue());
    }

    public void setEquivalence(Coins from, String to){
        this.equivalence = from.getEquivalence(to);
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
