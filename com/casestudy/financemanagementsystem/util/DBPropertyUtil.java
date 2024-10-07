package com.casestudy.financemanagementsystem.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DBPropertyUtil {
    public static String getConnectionString(String propertyFileName) {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream("D:\\java practice\\com\\casestudy\\financemanagementsystem\\util\\db.properties")) {

            properties.load(input);

            String hostName = properties.getProperty("host");
            String dbName = properties.getProperty("dbName");
            String userName = properties.getProperty("username");
            String password = properties.getProperty("password");
            String port = properties.getProperty("port");

            return "jdbc:mysql://" + hostName + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
