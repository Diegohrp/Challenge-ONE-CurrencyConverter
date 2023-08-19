package com.personal.converter.enums;

import com.personal.converter.interfaces.Enumerable;
import com.personal.converter.models.generals.Measurement;

import java.util.HashMap;

public enum Coins implements Enumerable {

    MXN(new Measurement("MXN", "$", "Peso Mexicano", "mx.png"),
        new HashMap<>() {{
            put("MXN", 1.0);
            put("EUR", 0.054);
            put("USD", 0.059);
            put("GBP", 0.046);
            put("JPY", 8.51);
            put("KRW", 78.23);
        }}), EUR(new Measurement("EUR", "€", "Euro", "eur.png"),
        new HashMap<>() {{
            put("MXN", 18.63);
            put("EUR", 1.0);
            put("USD", 1.10);
            put("GBP", 0.86);
            put("JPY", 158.56);
            put("KRW", 1458.27);
        }}), USD(new Measurement("USD", "$", "Dólar estadounidense", "usa.png"),
        new HashMap<>() {{
            put("MXN", 17.01);
            put("EUR", 0.91);
            put("USD", 1.0);
            put("GBP", 0.79);
            put("JPY", 144.73);
            put("KRW", 1330.60);
        }}), GBP(new Measurement("GBP", "£", "Libra esterlina", "uk.png"),
        new HashMap<>() {{
            put("MXN", 21.59);
            put("EUR", 1.16);
            put("USD", 1.27);
            put("GBP", 1.0);
            put("JPY", 183.85);
            put("KRW", 1689.60);
        }}), JPY(new Measurement("JPY", "¥", "Yen japonés", "japan.png"),
        new HashMap<>() {{
            put("MXN", 0.12);
            put("EUR", 0.0063);
            put("USD", 0.0069);
            put("GBP", 0.0054);
            put("JPY", 1.0);
            put("KRW", 9.19);
        }}), KRW(new Measurement("KRW", "₩", "Won surcoreano", "kor.png"),
        new HashMap<>() {{
            put("MXN", 0.013);
            put("EUR", 0.00069);
            put("USD", 0.00075);
            put("GBP", 0.00059);
            put("JPY", 0.11);
            put("KRW", 1.0);
        }});


    private final HashMap<String, Double> equivalences;
    private final Measurement coin;


    private Coins(Measurement coin, HashMap<String, Double> equivalences){
        this.coin = coin;
        this.equivalences = equivalences;
    }

    @Override public double getEquivalence(String to){
        return this.equivalences.get(to);
    }

    @Override public Measurement getObjFromEnum(){
        return this.coin;
    }
}
