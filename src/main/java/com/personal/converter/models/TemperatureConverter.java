package com.personal.converter.models;

import com.personal.converter.enums.Temperatures;

public class TemperatureConverter extends Converter {
    @Override
    public String getEquivalenceMsg(){
        return "";
    }

    @Override
    public String getResultMsg(){
        return this.getInput().getValue() + " " + this.getInput().getSymbol() + " = " +
            this.getOutput().getValue() + " " + this.getOutput().getSymbol();
    }

    @Override
    public void setEquivalence(String from, String to){
        Temperatures.valueOf(from).setTempValue(this.getInput().getValue());
        super.setEquivalence(Temperatures.valueOf(from).getEquivalence(to));
    }

    @Override
    public void convert(){
        this.getOutput().setValue(this.getEquivalence());
    }
}
