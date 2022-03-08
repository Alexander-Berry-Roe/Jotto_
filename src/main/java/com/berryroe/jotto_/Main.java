package com.berryroe.jotto_;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("jotto.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        stage.setTitle("Jotto");
        stage.setScene(new Scene(root, 650, 450));

        stage.show();

    }

    public void reset(){
        try {
            start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch();
    }
}