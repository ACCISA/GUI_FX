package com.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    public static boolean checkCreds(String inputU, String inputP) {
        String sql="SELECT password FROM accounts WHERE username=?";
        try {
            PreparedStatement checkStmt = Connections.con.prepareStatement(sql);
            checkStmt.setString(1, inputU);
            ResultSet rs = checkStmt.executeQuery();
            if(rs.next()) {
                String passRetrieved = rs.getString("password");
                if (passRetrieved.equals(inputP))return true;
                return false;
            } return false;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error acessing database");
            e.printStackTrace();
            return false;
        }

    }


}
