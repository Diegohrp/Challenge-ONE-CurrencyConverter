package com.personal.converter.utils;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.text.DecimalFormat;

public class Utils {

    public static String formatDouble(double num, int decimals){
        DecimalFormat format = new DecimalFormat(
            (num < 1 ? "0." : "#.") + "0".repeat(decimals));
        return format.format(num);
    }

    public static boolean validatePositiveDecimal(String txt){
        System.out.println("Positive decimal: " + txt);
        return txt.matches("^[0-9]+(\\.[0-9]+)?$") && txt.length() < 12;
    }

    public static boolean validateDecimal(String txt){
        System.out.println("Decimal: " + txt);
        return txt.matches("^-?[0-9]+(\\.[0-9]+)?$") && txt.length() < 12;
    }

}
