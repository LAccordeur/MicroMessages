package com.guoyang.db;

import java.sql.Connection;
import java.sql.*;

/**
 * Created by L'Accordeur on 2016/10/13.
 */
public class DBUtil_back {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc?characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "guoyang121";
    private Connection connection = null;

    public DBUtil_back() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnecion() {
        return connection;
    }
}
