package com.personal.converter.enums;

import com.personal.converter.interfaces.Enumerable;
import com.personal.converter.models.generals.Measurement;

import java.util.HashMap;

public enum Lengths implements Enumerable {

    m(new Measurement("m", "m", "Metros", ""),
        new HashMap<>() {{
        put("m", 1.0);
        put("cm", 100.0);
        put("km", 0.001);
        put("mm", 1000.0);
        put("mi", 0.000621371);
        put("ft", 3.28084);
        put("yd", 1.0936133333333);
    }}), cm(new Measurement("cm", "cm", "Centímetros", ""),
        new HashMap<>() {{
            put("m", 0.01);
            put("cm", 1.0);
            put("km", 1e-5);
            put("mm", 10.0);
            put("mi", 6.2137e-6);
            put("ft", 0.0328084);
            put("yd", 0.0109361);
        }}), km(new Measurement("km", "km", "Kilómetros", ""),
        new HashMap<>() {{
            put("m", 1000.0);
            put("cm", 100000.0);
            put("km", 1.0);
            put("mm", 1e+6);
            put("mi", 0.621371);
            put("ft", 3280.84);
            put("yd", 1093.61);
        }}), mm(new Measurement("mm", "mm", "Milímetros", ""),
        new HashMap<>() {{
            put("m", 0.001);
            put("cm", 0.1);
            put("km", 1e-6);
            put("mm", 1.0);
            put("mi", 6.2137e-7);
            put("ft", 0.00328084);
            put("yd", 0.00109361);
        }}), mi(new Measurement("mi", "mi", "Millas", ""),
        new HashMap<>() {{
            put("m", 1609.34);
            put("cm", 160934.0);
            put("km", 1.60934);
            put("mm", 1.609e+6);
            put("mi", 1.0);
            put("ft", 5280.0);
            put("yd", 1760.0);
        }}), ft(new Measurement("ft", "ft", "Pies", ""),
        new HashMap<>() {{
        put("m", 0.3048);
        put("cm", 30.48);
        put("km", 0.0003048);
        put("mm", 304.8);
        put("mi", 0.000189394);
        put("ft", 1.0);
        put("yd", 0.333333);
    }}), yd(new Measurement("yd", "yd", "Yardas", ""),
        new HashMap<>() {{
        put("m", 0.9144);
        put("cm", 91.44);
        put("km", 0.0009144);
        put("mm", 914.4);
        put("mi", 0.000568182);
        put("ft", 3.0);
        put("yd", 1.0);
    }});

    private final Measurement unit;
    private final HashMap<String, Double> equivalences;

    private Lengths(Measurement unit, HashMap<String, Double> equivalences){
        this.unit = unit;
        this.equivalences = equivalences;
    }

    @Override public double getEquivalence(String to){
        return this.equivalences.get(to);
    }

    @Override public Measurement getObjFromEnum(){
        return this.unit;
    }
}
