package com.ohgiraffers.chap11.section02.uses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {
    /* 1. 놈캣 10버전 미만 : POST 전송 시 한글 값 문자 셋 미설정으로 인한 깨짐 현상
    * 2. 비밀번호 암호화 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        System.out.println("userId : {}, password : {}, name : {}"  + userId + password + name);

        /* 암호화 된ㅁ 패스워드는 동일 값이 입력되더라도 매번 실행 시 salt에 의해 다른 값을 가지게 된다.
        * 입력 값 동일 여부 확인은 matches라는 메소드를 통해 확인해야 한다.*/
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("비밀번호 일치여부 : " + encoder.matches("tg1234", password));
    }
}
