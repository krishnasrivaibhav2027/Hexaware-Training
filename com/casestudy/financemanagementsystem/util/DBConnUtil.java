package com.casestudy.financemanagementsystem.util;
import java.sql.*;
public class DBConnUtil {
    private static Connection connection;
    public static Connection getConnection(){
        if(connection == null){
            try{
                String connString = DBPropertyUtil.getConnectionString("db.properties");
                connection = DriverManager.getConnection(connString);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return connection;
    }
}
