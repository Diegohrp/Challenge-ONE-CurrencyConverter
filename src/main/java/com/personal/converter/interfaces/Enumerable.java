package com.personal.converter.interfaces;

import com.personal.converter.models.generals.Measurement;

public interface Enumerable {

    double getEquivalence(String to);

    Measurement getObjFromEnum();
}
