package com.func;

import com.fxproject.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Instance {

    public Instance(Class<Controller> UI, String title){
        Stage stageUI = new Stage();
        stageUI.getIcons().add(new Image("C:\\Users\\darra\\IdeaProjects\\FXProject\\src\\main\\java\\com\\fxproject\\concordia-logo.png"));
        try{
            URL fxmlLocation = UI.getResource(title);
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Parent root = loader.load(fxmlLocation);
            Scene scene = new Scene(root);
            stageUI.setScene(scene);
            if (title.equals("add-user-ui.fxml")){
                stageUI.setTitle("Add User Form");
                stageUI.setResizable(false);
            } else if (title.equals("login-ui.fxml")) {
                stageUI.setResizable(false);
                stageUI.setTitle("Login");

            } else if (title.equals("view-user-ui.fxml")){
                stageUI.setResizable(true);
                stageUI.setTitle("View Users");
            }
            stageUI.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
