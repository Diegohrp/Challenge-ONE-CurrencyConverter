package com.personal.converter.interfaces;

import com.personal.converter.models.Measurement;

public interface Enumerable {

    double getEquivalence(String to);

    Measurement getObjFromEnum();
}
