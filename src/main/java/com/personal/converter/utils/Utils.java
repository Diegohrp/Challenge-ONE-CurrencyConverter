package com.personal.converter.utils;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.text.DecimalFormat;

public class Utils {

    public static String formatDouble(double num, int decimals){
        DecimalFormat format = new DecimalFormat((num < 1 ? "0." : "#.") + "0".repeat(decimals));
        return format.format(num);
    }

    public static boolean validatePositiveDecimal(String txt){
        return txt.matches("^[0-9]+(\\.[0-9]+)?$") && txt.length() < 12;
    }

    public static void validateTextField(boolean isValid, Label errorLabel, HBox textContainer, Button convertBtn){
        if (isValid) {
            errorLabel.setText("");
            textContainer.setStyle("-fx-border-color:#d1d1d1;");
            convertBtn.setDisable(false);
        } else {
            errorLabel.setText("Introduce un número válido");
            textContainer.setStyle("-fx-border-color:red;");
            convertBtn.setDisable(true);
        }
    }
}
