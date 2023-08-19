package com.personal.converter.utils;

import com.personal.converter.Main;
import com.personal.converter.models.Measurement;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.Objects;

public class GUIFeatures {
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

    //Creates a list cell of items of type |text Image|
    public static ListCell<Measurement> createListCell(){
        return new ListCell<>() {
            @Override protected void updateItem(Measurement item, boolean empty){
                super.updateItem(item, empty);
                GUIFeatures.setComboBoxItem(this, item, empty);
            }
        };
    }

    public static void validateTextField(boolean isValid, Label errorLabel,
                                         HBox textContainer, Button convertBtn){
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
