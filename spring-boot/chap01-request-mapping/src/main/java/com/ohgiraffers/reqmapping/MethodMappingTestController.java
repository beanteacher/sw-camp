package com.ohgiraffers.reqmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* DispatcherServle은 웹 요청을 받는 즉시 @Controller가 달린 컨트롤러 클래스에 처리를 위임한다.
* 그 과정은 컨트롤러 클래스의 핸들러 메서드에 선언 된 다양한 @RequestMapping 설정 내용에 따른다.*/
@Controller
public class MethodMappingTestController {

    /* 1. 등록 메소드 지정 */
    @RequestMapping("/menu/regist")
    public String menuRegist(Model model) {
        /* Model 객체에ㅔ addAttribute 메서드를 이용해 key, value를 추가하면
        * view에서 사용할 수 있다. -> chap03-view resolver에서 다시 다룸 */
        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출");
        /* 반환하고자 하는 view의 경로를 포함한 이름을 작성한다.
        * resources/templates 하위부터의 경로를 작성한다.
        * chap03-view-resolver에서 다시 다룸 */
        return "mappingResult";
    }

    /* 2. 요청 메소드 지정 */
    @RequestMapping(value = "/menu/modify", method = RequestMethod.GET)
    public String menuModify(Model model) {
        model.addAttribute("message", "GET 방식의 메뉴 수정용 핸들러 메소드 호출");
        return "mappingResult";
    }

    /* 3. 요청 메소드 전용 어노테이션 */
    @RequestMapping(value = "/menu/delete")
    public String getMenuDelete(Model model) {
        model.addAttribute("message", "GET 방식의 메뉴 삭제용 핸들러 메소드 호출");
        return "mappingResult";
    }

    @RequestMapping(value = "/menu/modify")
    public String postMenuDelete(Model model) {
        model.addAttribute("message", "POST 방식의 메뉴 삭제용 핸들러 메소드 호출");
        return "mappingResult";
    }
}