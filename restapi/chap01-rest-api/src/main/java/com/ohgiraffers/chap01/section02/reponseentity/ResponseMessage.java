package com.ohgiraffers.chap01.section02.reponseentity;

import com.ohgiraffers.chap01.section01.response.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseMessage {
    private int httpStatus;
    private String message;
    private Map<String, Object> results;
}