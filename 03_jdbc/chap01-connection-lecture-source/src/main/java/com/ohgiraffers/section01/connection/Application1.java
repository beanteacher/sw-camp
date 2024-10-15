package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* 해당 DBMS와 계정에 맞는 Connection 객체를 생성할 수 있다. */
public class Application1 {

    public static void main(String[] args) {

        Connection con = null;
        try {
            // 문자열로 작성 된 class 명칭이 잘 못 되었을 경우 ClassNotFoundException 이 발생할 수 있으므로
            // Exception handling 한다.
            Class.forName("com.mysql.cj.jdbc.Driver");
            // DBMS 연결 정보가 잘못 된 경우 connection 객체 생성이 불가능하므로 SQLException 발생할 수 있다.
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "practice", "practice");

            System.out.println("con = " + con);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
