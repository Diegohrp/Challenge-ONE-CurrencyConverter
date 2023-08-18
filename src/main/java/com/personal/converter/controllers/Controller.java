package com.personal.converter.controllers;

import com.personal.converter.Main;
import com.personal.converter.enums.Coins;
import com.personal.converter.interfaces.Enumerable;
import com.personal.converter.models.Converter;
import com.personal.converter.models.Measurement;
import com.personal.converter.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.util.ArrayList;
import java.util.Objects;


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

    //configuration for the combo boxes
    private void setOptions(ComboBox<Measurement> comboBox, ArrayList<Measurement> opts){
        comboBox.getItems().addAll(opts);
        comboBox.setCellFactory(param -> this.createListCell());
        comboBox.setButtonCell(this.createListCell());
    }

    private void prepareComboBoxes(ArrayList<Measurement> options){
        this.setOptions(fromOptions, options);
        this.setOptions(toOptions, options);
        toOptions.setOnAction(this::setToOptions);
        fromOptions.setOnAction(this::setFromOptions);
    }

    public void initComponents(ArrayList<Measurement> options){
        this.prepareComboBoxes(options);
        convertBtn.setDisable(true);
        fromOptions.setValue(options.get(0));
        toOptions.setValue(options.get(0));
        symbolLabel.setText(options.get(0).getSymbol());
    }

    public void setConverter(Converter converter){
        this.converter = converter;
    }

    public HBox getTextInputContainer(){
        return textInputContainer;
    }

    public TextField getTextInput(){
        return textInput;
    }

    public Button getConvertBtn(){
        return convertBtn;
    }

    public Label getErrorLabel(){
        return errorLabel;
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
        if (!textInput.getText().equals("")) this.convert();

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


    //Create a list cell of items of type |text Image|
    private ListCell<Measurement> createListCell(){
        return new ListCell<>() {
            @Override protected void updateItem(Measurement item, boolean empty){
                super.updateItem(item, empty);
                Controller.setComboBoxItem(this, item, empty);
            }
        };
    }

    //Method to add text and an Image to an option of a combo box
    private static void setComboBoxItem(ListCell<Measurement> listCell, Measurement item,
                                        boolean empty){

        HBox hBox = new HBox(0);
        if (empty || item == null) {
            listCell.setGraphic(null);
        } else {
            Label labelKey = new Label();
            Label labelName = new Label();

            labelKey.setPrefWidth(40);
            labelKey.setStyle("-fx-text-fill:#141e37;");
            labelKey.setText(item.getId());

            labelName.setPrefWidth(150);
            labelName.setText(item.getName());
            labelName.setStyle("-fx-text-fill:#667a91;");

            if (!item.getImgPath().equals("")) {
                ImageView imageView = new ImageView();
                imageView.setImage(new Image(Objects.requireNonNull(
                    Main.class.getResourceAsStream("assets/img/" + item.getImgPath()))));
                imageView.setFitHeight(32);
                imageView.setFitWidth(32);
                hBox.getChildren().addAll(labelKey, labelName, imageView);
            } else {
                hBox.getChildren().addAll(labelKey, labelName);
            }
            hBox.setAlignment(Pos.CENTER_LEFT);
            listCell.setGraphic(hBox);
        }
    }
}
