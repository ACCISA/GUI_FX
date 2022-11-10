package com.fxproject;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

public class Controller implements Initializable {

    @FXML
    private JFXButton loginBtn;

    @FXML
    private ImageView loginImage;

    @FXML
    private Button testClick;
    @FXML
    private PasswordField passwordField;

    @FXML
    private JFXButton registerBtn;

    @FXML
    private TextField usernameField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        registerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


            }
        });
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String usernameInput = usernameField.getText();
                String passwordInput = passwordField.getText();
                if (com.db.Login.checkCreds(usernameInput,passwordInput)) {
                    System.out.println("Valid Login");
                } else System.out.println("Invalid Login");            }
        });
    }


//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
}