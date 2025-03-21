package com.cisco.prj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
    private static String DRIVER  = "";
    private static String URL = "";
    private static  String USER = "";
    private static String PWD = "";
    // load drivers of database
    static  {
        ResourceBundle res = ResourceBundle.getBundle("config");
        DRIVER = res.getString("DRIVER");
        URL = res.getString("URL");
        USER = res.getString("USER");
        PWD = res.getString("PWD");

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(URL , USER, PWD);
    }

    public  static void closeConnection(Connection con)  {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
