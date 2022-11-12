package com.fxproject;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import javafx.stage.Stage;

public class Controller{

    public void loginUser(){
        String usernameInput = usernameField.getText();
        String passwordInput = passwordField.getText();
        loginBtn.getScene().getWindow().hide();
        Stage menuStage = new Stage();
        if (com.db.Login.checkCreds(usernameInput,passwordInput)) {
            System.out.println("[APP] User Logged In");
            try{
                URL fxmlLocation = Controller.class.getResource("menu.fxml");
//            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("menu.fxml"));
                FXMLLoader loader = new FXMLLoader(fxmlLocation);
                Parent root = loader.load(fxmlLocation);
                Scene scene = new Scene(root);
                menuStage.setScene(scene);
                menuStage.show();
                menuStage.setResizable(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else ;


    }
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

    @FXML
    void initialize() {

        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                loginUser();
            }
        });
    }


//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
}