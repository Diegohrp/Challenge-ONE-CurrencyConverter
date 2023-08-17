package com.personal.converter.models;
import com.personal.converter.utils.Utils;

public class CoinsConverter extends Converter {


    public CoinsConverter(Measurement coin){
        super(coin.getId(), coin.getSymbol(), coin.getName());
    }

    @Override
    public String getResultMsg(){
        return this.getInput().getSymbol()+" "+ Utils.formatDouble(this.getInput().getValue(),2)+
                " "+this.getInput().getId()+ " = "+this.getOutput().getSymbol()+
                " "+Utils.formatDouble(this.getOutput().getValue(),2)+" "+this.getOutput().getId();
    }
}
