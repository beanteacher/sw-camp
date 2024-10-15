package com.ohgiraffers.exceptionhandler;

import org.springframework.web.bind.annotation.GetMapping;

public class OtherController {
    @GetMapping("/other-controller-null")
    public String nullPointerExceptionTest() {
        String str = null;
        System.out.println(str.charAt(0));
        return "/";
    }

    @GetMapping("/other-controller-user")
    public String userExceptionTest() throws MemberRegistException {
        boolean check = true;
        if(check) throw new MemberRegistException("당신 같은 사람은 회원이 될 수 없어");

        return "/";
    }

    @GetMapping("/other-controller-array")
    public String arrayExceptionTest() {
        double[] array = new double[0];
        System.out.println(array[0]);

        return "/";
    }
}
