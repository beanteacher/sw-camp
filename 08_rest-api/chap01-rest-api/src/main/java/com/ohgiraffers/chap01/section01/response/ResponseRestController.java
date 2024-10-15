package com.ohgiraffers.chap01.section01.response;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* @RestController : 모든 핸들러 메소드에 @ResponseBody가 적용된 것과 같다.
* 반환 값이 응답 데이터이다. */
@RestController
@RequestMapping(value = "/response")
public class ResponseRestController {
    /* 1. 문자열 응답 */
    @GetMapping(value = "/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    /* 2. 객체 응답 */
    @GetMapping(value = "/message")
    public Message getMessage() {
        return new Message(200, "메시지를 응답합니다.");
    }

    /* 3. List 응답 */
    @GetMapping(value = "/list")
    public List<String> getList() {
        return List.of(new String[]{"사과","복숭아","바나나"});
    }

    @GetMapping(value = "/map")
    public Map<Integer, String> getMap() {
        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(200, "정상"));
        messageList.add(new Message(404, "페이지를 찾을 수 없습니다."));
        messageList.add(new Message(500, "개발자의 잘못입니다."));
        return messageList.stream().collect(Collectors.toMap(Message::getHttpStatusCode, Message::getMessage));
    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage() throws IOException {
        return getClass().getResourceAsStream("/images/test.png").readAllBytes();
    }

    /* 6. ResponseEntity 응답 */
    @GetMapping("/entity")
    public ResponseEntity<Message> getEntity() {
        return ResponseEntity.ok(new Message(200, "hello world"));
    }
}
