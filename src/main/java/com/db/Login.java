package com.db;

import com.func.Utils;
import com.fxproject.Controller;

import java.io.IOException;
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

    public static boolean doesUserExists(String username) {
        String sql = "SELECT password FROM accounts WHERE username=?";
        try{
            PreparedStatement checkStmt = Connections.con.prepareStatement(sql);
            checkStmt.setString(1,username);
            ResultSet rs = checkStmt.executeQuery();
            if(rs.next()){
//                String passRetrieved = rs.getString("password");
//                System.out.println(passRetrieved);
//                if (passRetrieved.length() > 0) return true;
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.out.println("[DB] Error Looking for Existing User");
            e.printStackTrace();
            return false;
        }
    }

    public static void log(){
        String sql = "INSERT INTO accounts_logs (username, time) VALUEs (?,?)";
        try{
            PreparedStatement stmt = Connections.con.prepareStatement(sql);
            stmt.setString(1, Controller.curUser);
            stmt.setString(2, Utils.getTime());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("[DB] Error Creating User");
            e.printStackTrace();
        }
    }


}
