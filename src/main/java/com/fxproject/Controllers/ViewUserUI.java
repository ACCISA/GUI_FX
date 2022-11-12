package com.fxproject.Controllers;

import com.db.FetchData;
import com.fxproject.Controllers.ColumnData.RowData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ViewUserUI implements Initializable {

    @FXML
    private TableView<RowData> tableUsers;

    @FXML
    private TableColumn<RowData, String> colUserID;

    @FXML
    private TableColumn<RowData, String> colCaller;

    @FXML
    private TableColumn<RowData, String> colUsername;

    @FXML
    private TableColumn<RowData, String> colOriginalPassword;

    @FXML
    private TableColumn<RowData, String> colCurrentPassword;

    @FXML
    private TableColumn<RowData, String> colCreatedOn;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colUserID.setCellValueFactory(new PropertyValueFactory<RowData, String>("userID"));
        colCaller.setCellValueFactory(new PropertyValueFactory<RowData, String>("caller"));
        colUsername.setCellValueFactory(new PropertyValueFactory<RowData, String>("username"));
        colOriginalPassword.setCellValueFactory(new PropertyValueFactory<RowData, String>("original_password"));
        colCurrentPassword.setCellValueFactory(new PropertyValueFactory<RowData, String>("current_password"));
        colCreatedOn.setCellValueFactory(new PropertyValueFactory<RowData, String>("createDate"));

        tableUsers.setItems(createUserList());
    }

    public ObservableList<RowData> createUserList(){
        FetchData getDataFromDB = new FetchData();
        ObservableList<RowData> dataGet = getDataFromDB.FetchData("account_creation_logs");
        return dataGet;
    }

}
