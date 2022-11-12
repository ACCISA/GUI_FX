package com.fxproject;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
// test git commit
public class MenuUI extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        int width = (int) Screen.getPrimary().getBounds().getWidth();
        int height = (int) Screen.getPrimary().getBounds().getHeight();
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - width) / 2);
        stage.setY((screenBounds.getHeight() - height) / 2);
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Menu");

//        stage.setResizable(false);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
        System.out.println("[Login] Login UI Started");


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