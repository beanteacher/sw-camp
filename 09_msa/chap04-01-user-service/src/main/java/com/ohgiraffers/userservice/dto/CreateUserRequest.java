package com.ohgiraffers.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    private String userId;
    private String pwd;
    private String email;
    private String name;
}
