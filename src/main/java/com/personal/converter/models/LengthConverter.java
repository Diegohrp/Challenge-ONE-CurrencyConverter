package com.personal.converter.models;

import com.personal.converter.enums.Lengths;
import com.personal.converter.utils.Utils;

public class LengthConverter extends Converter {

    @Override
    public String getEquivalenceMsg(){
        return " 1 " + this.getInput().getId() + " = " + this.getEquivalence() + " " +
            this.getOutput().getId();
    }

    @Override
    public String getResultMsg(){
        return Utils.formatDouble(this.getInput().getValue(), 4) + " " +
            this.getInput().getId() + " = " + " " +
            Utils.formatDouble(this.getOutput().getValue(), 4) + " " +
            this.getOutput().getId();
    }

    @Override
    public void setEquivalence(String from, String to){
        super.setEquivalence(Lengths.valueOf(from).getEquivalence(to));
    }
}
