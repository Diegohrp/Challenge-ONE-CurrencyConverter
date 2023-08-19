package com.personal.converter.enums;

import com.personal.converter.interfaces.Enumerable;
import com.personal.converter.models.Measurement;
import java.util.HashMap;
import java.util.function.DoubleUnaryOperator;

public enum Temperatures implements Enumerable {

    C(new Measurement("C", "°C", "Grado Celcius", ""),
        new HashMap<>() {{
        put("C", (c) -> c);
        put("F", (c) -> c * (9.0 / 5) + 32);
        put("K", (c) -> c + 273.15);

    }}),
    F(new Measurement("F", "°F", "Grado Fahrenheit", ""),
        new HashMap<>() {{
        put("C", (f) -> (f - 32) * (5 / 9.0));
        put("F", (f) -> f);
        put("K", (f) -> (f - 32) * (5 / 9.0) + 273.15);

    }}),
    K(new Measurement("K", "°K", "Grado Kelvin", ""),
        new HashMap<>() {{
        put("C", (k) -> k-273.15);
        put("F", (k) -> (k - 273.15) * (9.0 / 5) + 32);
        put("K", (k) -> k);

    }});


    private final Measurement temp;
    private final HashMap<String, DoubleUnaryOperator> equivalences;

    private Temperatures(Measurement temp,
                         HashMap<String, DoubleUnaryOperator> equivalences){
        this.temp = temp;
        this.equivalences = equivalences;
    }

    @Override
    public double getEquivalence(String to){
        return this.equivalences.get(to).applyAsDouble(this.temp.getValue());
    }

    public void setTempValue(double value){
        this.temp.setValue(value);
    }

    @Override
    public Measurement getObjFromEnum(){
        return this.temp;
    }
}
