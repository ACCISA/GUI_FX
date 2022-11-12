package com.fxproject;

import com.func.Instance;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MenuController {

    @FXML
    private MenuItem editCredentialsMenuItem;

    @FXML
    private MenuItem logoutMenuItem;

    @FXML
    private Button testButton;

    @FXML
    private MenuItem addUserMenuItem;

    @FXML
    void initialize(){

        logoutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("[APP] Logging Out");
                logoutUser();
            }
        });

        addUserMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("[APP] Opening AddUser Form");
                addUser();
            }
        });
    }

    public void logoutUser(){
        testButton.getScene().getWindow().hide();
        Instance logoutUI = new Instance(Controller.class, "login-ui.fxml");

    }

    public void addUser(){
        Instance addUser = new Instance(Controller.class, "add-user-ui.fxml");

    }

}