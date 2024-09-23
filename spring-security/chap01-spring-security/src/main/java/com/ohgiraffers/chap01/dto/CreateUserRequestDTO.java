package com.ohgiraffers.chap01.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class CreateUserRequestDTO {

    private String userId;
    private String userPwd;
    private String userEmail;
    private String userName;
}
