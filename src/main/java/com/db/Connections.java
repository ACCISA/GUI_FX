package com.db;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.Connection;

public class Connections {

    public static Connection con;

    public static void connect() {
        if (con != null) return;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace();
        }
        String url = "jdbc:mysql://16/appdb";
        try {
            con = (Connection) DriverManager.getConnection(url, "root", "");
            System.out.println("[DB] Connected");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        if (con != null) {
            try {
                con.close();
                System.out.println("[DB] Disconnected");

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Cant close connection");
                e.printStackTrace();
            }
        }
    }

}
