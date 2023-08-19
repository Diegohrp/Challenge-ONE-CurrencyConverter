package com.personal.converter.models;

import com.personal.converter.enums.Temperatures;
import com.personal.converter.models.generals.Converter;
import com.personal.converter.utils.Utils;

public class TemperatureConverter extends Converter {
    @Override public String getEquivalenceMsg(){
        return "";
    }

    @Override
    public String getResultMsg(){
        return Utils.formatDouble(this.getInput().getValue(), 2) + " " +
            this.getInput().getSymbol() + " = " +
            Utils.formatDouble(this.getOutput().getValue(), 2) + " " +
            this.getOutput().getSymbol();
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
