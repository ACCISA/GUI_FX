package com.db;

import com.fxproject.Controllers.ColumnData.RowData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FetchData {

    public ObservableList<RowData> FetchData(String database){
        ArrayList<RowData> usersList = new ArrayList<RowData>();
        if (database.equals("account_creation_logs")){
            String sql="SELECT * FROM account_creation_logs";
            try {
                PreparedStatement checkStmt = Connections.con.prepareStatement(sql);
                ResultSet rs = checkStmt.executeQuery();
                while(rs.next()) {
                    String userID = rs.getString("logID");
                    String caller = rs.getString("caller");
                    String username = rs.getString("username");
                    String original_password = rs.getString("original_password");
                    String current_password = rs.getString("current_password");
                    String time_created = rs.getString("time");
                    usersList.add(new RowData(userID,caller,username,original_password,current_password,time_created));
                }
                ObservableList<RowData> list = FXCollections.observableArrayList(usersList);

                return list;
            } catch (SQLException e) {
                System.out.println("Error acessing database");
                e.printStackTrace();
                ObservableList<RowData> list = FXCollections.observableArrayList(usersList);

                return list;
            }
        }
        ObservableList<RowData> list = FXCollections.observableArrayList(usersList);
        return list;
    }

}
