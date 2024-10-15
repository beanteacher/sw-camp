package com.ohgiraffers.chap11.section02.uses;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String value;

        if("password".equals(name)) {
            // 비밀번ㅂ호 암호화 처리한 값으로 변경한다.
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            value = encoder.encode(super.getParameter(name));
        } else {
            value = super.getParameter(name);
        }
        return value;
    }
}
