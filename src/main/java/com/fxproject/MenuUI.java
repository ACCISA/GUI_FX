package com.fxproject;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
// test git commit
public class MenuUI extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        double width = 640;
        double height = 480;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - width) / 2);
        stage.setY((screenBounds.getHeight() - height) / 2);
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 567, 279);
        stage.setTitle("Menu");
        stage.setResizable(false);
        stage.setScene(scene);

        System.out.println("[Login] Login UI Started");
        Platform.runLater(() ->{
            stage.show();
        });


    }

    @Override
    public void init() throws Exception {
        // DB connection create when init
        com.db.Connections.connect();
        super.init();
    }

    @Override
    public void stop() throws Exception {
        com.db.Connections.disconnect();
        super.stop();
    }


}