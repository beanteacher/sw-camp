package com.ohgiraffers.chap01.section01.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Message {
    private int httpStatusCode;
    private String message;
}