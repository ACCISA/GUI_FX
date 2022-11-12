package com.fxproject;

import com.db.AddUser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import static com.db.Login.doesUserExists;

public class AddUserController {

    @FXML
    private TextField addUsername;

    @FXML
    private PasswordField addPassword;

    @FXML
    private JFXButton createUser;

    @FXML
    private PasswordField addPasswordConfirm;
    @FXML
    void initialize(){


        createUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("[USER] Checking Add User Form Values");
                if (isValidInput()) {
                    System.out.println("[USER] User Successfully Created");
                    return;

                }
                System.out.println("[USER] Failed Creating User");
            }
        });
    }

    public boolean isValidInput() {
        String usernameInput = addUsername.getText();
        String passwordInput = addPassword.getText();
        String passwordInputConfirm = addPasswordConfirm.getText();
        if (!(passwordInput.equals(passwordInputConfirm))){System.out.println("[USER] Password don't Match");return false;}
        if (usernameInput.length()==0 || passwordInputConfirm.length()==0 || passwordInput.length()==0) return false;
        if ((doesUserExists(usernameInput))){System.out.println("[USER] Username Already Exists");return false;}
        AddUser creatingUser = new AddUser(usernameInput,passwordInput);
        AddUser.log();
        return true;
    }

}