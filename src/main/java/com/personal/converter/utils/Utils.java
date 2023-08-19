package com.personal.converter.utils;

import java.text.DecimalFormat;

public class Utils {

    public static String formatDouble(double num, int decimals){
        DecimalFormat format = new DecimalFormat(
            (num < 1 ? "0." : "#.") + "0".repeat(decimals));
        return format.format(num);
    }

    public static boolean validatePositiveDecimal(String txt){
        return txt.matches("^[0-9]+(\\.[0-9]+)?$") && txt.length() < 12;
    }

    public static boolean validateDecimal(String txt){
        return txt.matches("^-?[0-9]+(\\.[0-9]+)?$") && txt.length() < 12;
    }

}
