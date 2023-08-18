package com.personal.converter.models;

import com.personal.converter.enums.Coins;
import com.personal.converter.utils.Utils;

public class CoinsConverter extends Converter {


    public CoinsConverter(Measurement coin){
        this.initInOut(coin);
    }

    @Override public String getEquivalenceMsg(){
        return this.getInput().getSymbol() + " 1 " + this.getInput().getId() + " = " +
            this.getOutput().getSymbol() + " " + this.getEquivalence() + " " +
            this.getOutput().getId();
    }

    @Override public String getResultMsg(){
        return this.getInput().getSymbol() + " " +
            Utils.formatDouble(this.getInput().getValue(), 2) + " " +
            this.getInput().getId() + " = " + this.getOutput().getSymbol() + " " +
            Utils.formatDouble(this.getOutput().getValue(), 2) + " " +
            this.getOutput().getId();
    }

    @Override public void setEquivalence(String from, String to){
        super.setEquivalence(Coins.valueOf(from).getEquivalence(to));
    }
}
