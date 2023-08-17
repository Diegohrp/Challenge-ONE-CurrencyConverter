package com.personal.converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    

    public static void main(String[] args){
        launch();
    }
    @Override public void start(Stage stage) throws IOException{
        Parent root =  FXMLLoader.load(getClass().getResource("views/coins-view.fxml"));
        Scene scene = new Scene(root);
        String css = getClass().getResource("views/styles.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();

    }

}
