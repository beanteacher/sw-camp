package com.ohgiraffers.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {

    @GetMapping("/controller-null")
    public String nullPointerExceptionTest() {
        String str = null;
        System.out.println(str.charAt(0));
        return "/";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException e) {
        System.out.println("특정 Controller 범위의 Exception이 발생하였습니다.");
        System.out.println(e);
        return "error/nullPointer";
    }

    @GetMapping("/controller-user")
    public String userExceptionTest() throws MemberRegistException {
        boolean check = true;
        if(check) throw new MemberRegistException("당신 같은 사람은 회원이 될 수 없어");

        return "/";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String memberRegistExceptionHandler(MemberRegistException e, Model model) {
        model.addAttribute("Exception", e);
        return "error/memberRegist";
    }
}
