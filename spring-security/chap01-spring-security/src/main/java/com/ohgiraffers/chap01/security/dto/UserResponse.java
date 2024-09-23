package com.ohgiraffers.chap01.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private String userId;
    private String userEmail;
    private String userName;
}
