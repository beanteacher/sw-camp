package com.ohgiraffers.common;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {
    public static Connection getConnection() {
        Properties props = new Properties();
        Connection con = null;

        try {
            props.load(new FileReader("src/main/java/com/ohgiraffers/config/jdbc-config.properties"));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
//            con = DriverManager.getConnection(url, props); -> props 파일에서 user, password 키 값을 읽어서 처리

            System.out.println("con = " + con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        /* connection을 닫는 개념은 별도로 분리하고 실제 닫는 시점은 추후 Service 계층에서 진행할 예정이다. */

        return con;
    }

    public static void close(Connection con) {
        try {
            if (con != null && !con.isClosed()) con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt) {
        try {
            if(stmt != null && !stmt.isClosed()) stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset) {
        try {
            if(rset != null && !rset.isClosed()) rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }










}
