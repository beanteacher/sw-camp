package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/* PreparedStatement는 Statement와 달리 최초 한 번 쿼리를 파싱하고 컴파일하고 캐싱하여 다시
* 재해석하는 과정(비용)을 생략함으로써 불완전하게 작성 된 쿼리 실행의 경우는 Statement보다 빠르다. */
public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("사번 입력 : ");
        String empId = sc.nextLine();
        String entYn = "N";
        /* PreparedStatement는 Statement와 달리 placeholder(?)를 활용한 하나의 문자열 형태로 쿼리를 작성한다. */
        String query = "select emp_id, emp_name from employee where emp_id = ? and ent_yn = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);
            pstmt.setString(2, entYn);

            rset = pstmt.executeQuery();

            if (rset.next()) {
                System.out.println(rset.getString("emp_id") + " " + rset.getString("emp_name"));
            } else {
                System.out.println("해당 사번의 사원이 존재하지 않습니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }


    }
}
