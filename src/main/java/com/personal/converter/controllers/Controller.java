package com.personal.converter.controllers;

import com.personal.converter.Main;
import com.personal.converter.enums.Coins;
import com.personal.converter.enums.Lengths;
import com.personal.converter.enums.Temperatures;
import com.personal.converter.interfaces.Enumerable;
import com.personal.converter.models.CoinsConverter;
import com.personal.converter.models.Converter;
import com.personal.converter.models.Measurement;
import com.personal.converter.models.TemperatureConverter;
import com.personal.converter.utils.GUIFeatures;
import com.personal.converter.utils.Utils;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;


public class Controller {
    @FXML
    HBox textInputContainer;
    @FXML
    private TextField textInput;
    @FXML
    private Button convertBtn;
    @FXML
    private ComboBox<Measurement> fromOptions, toOptions;
    @FXML
    private Label result, equivalence, symbolLabel, errorLabel;

    private Converter converter;
    private ArrayList<Measurement> options;

    //generates an ArrayList<Measurement> for the combo boxes
    private void setOptions(Enumerable[] values){
        this.options = new ArrayList<>();
        for (Enumerable val : values) {
            this.options.add(val.getObjFromEnum());
        }
    }

    //configuration for the combo boxes
    private void setOptions(ComboBox<Measurement> comboBox){
        comboBox.getItems().addAll(this.options);
        comboBox.setCellFactory(param -> GUIFeatures.createListCell());
        comboBox.setButtonCell(GUIFeatures.createListCell());
        comboBox.setValue(this.options.get(0));

    }

    private void prepareComboBoxes(){
        this.setOptions(fromOptions);
        this.setOptions(toOptions);
        fromOptions.setOnAction(this::setFromOptions);
        toOptions.setOnAction(this::setToOptions);

    }

    private void addValidation(Enumerable type){
        this.textInput.textProperty().addListener((observable, oldValue, newValue) -> {
            boolean isValid;
            if (type instanceof Temperatures) {
                isValid = Utils.validateDecimal(newValue);
            } else {
                isValid = Utils.validatePositiveDecimal(newValue);
            }
            System.out.println(isValid);
            GUIFeatures.validateTextField(isValid, this.errorLabel,
                this.textInputContainer, this.convertBtn);
        });
    }

    public void startConverter(Enumerable[] enumValues, Converter converter){
        this.setOptions(enumValues);
        this.prepareComboBoxes();
        convertBtn.setDisable(true);
        symbolLabel.setText(options.get(0).getSymbol());
        this.converter = converter;
        this.converter.setInOut(options.get(0));
        this.addValidation(enumValues[0]);
    }


    private void setInputValue(){
        //if the user wrote an input in the text field set the value of inputCoin
        if (!textInput.getText().equals("") && textInput.getText().length() < 12) {
            //gets the value in the textInput and parses it to double
            try {
                double inputValue = Double.parseDouble(textInput.getText());
                converter.getInput().setValue(inputValue);
            } catch (NumberFormatException e) {
                //if the user doesn't write a number
                System.out.println(e.getMessage());
                converter.getInput().setValue(0);
            }
        }
    }

    /*
        Adds the data of the selected option from the ComboBox as the data of the Input or
        Output of the Converter
    */
    private void setOptionToConverter(Measurement option, Measurement inputOutput){
        inputOutput.setId(option.getId());
        inputOutput.setName(option.getName());
        inputOutput.setSymbol(option.getSymbol());
        /*
            When an option is chosen, sets the value in the textField to the attribute
            "value" of the object Input in the converter
        */
        this.setInputValue();
    }

    public void setFromOptions(ActionEvent event){
        this.setOptionToConverter(fromOptions.getValue(), converter.getInput());
        //adds to the label the corresponding currency symbol
        symbolLabel.setText(converter.getInput().getSymbol());
    }

    public void setToOptions(ActionEvent event){
        this.setOptionToConverter(toOptions.getValue(), converter.getOutput());
    }

    public void convert(){
        this.setInputValue();
        //looks for the equivalence in the enum and sets it to the converter
        converter.setEquivalence(converter.getInput().getId(),
            converter.getOutput().getId());
        converter.convert();
        result.setText(converter.getResultMsg());
        equivalence.setText(converter.getEquivalenceMsg());

    }

    public void swap(ActionEvent event){
        Measurement aux = fromOptions.getValue();
        fromOptions.setValue(toOptions.getValue());
        toOptions.setValue(aux);

        //this happens when there's a value in the text field and the swap button was clicked
        if (!textInput.getText().equals("")) {
            this.convert();
        } else {
            System.out.println("Ta vacío");
        }


    }

    private void goToAnotherScene(String viewPath, ActionEvent event){
        try {
            Parent newRoot = FXMLLoader.load(Main.class.getResource("views/" + viewPath));
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene newScene = new Scene(newRoot);
            String css = Main.class.getResource("views/styles.css").toExternalForm();

            newScene.getStylesheets().add(css);
            currentStage.setScene(newScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToTemperature(ActionEvent event){

        this.goToAnotherScene("temperature-view.fxml", event);
    }

    public void goToLength(ActionEvent event){
        this.goToAnotherScene("length-view.fxml", event);
    }

    public void goToCoins(ActionEvent event){
        this.goToAnotherScene("coins-view.fxml", event);
    }
}
