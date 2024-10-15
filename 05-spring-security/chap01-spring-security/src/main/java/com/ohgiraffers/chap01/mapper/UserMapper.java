package com.ohgiraffers.chap01.mapper;

import com.ohgiraffers.chap01.dto.CreateUserRequestDTO;
import com.ohgiraffers.chap01.aggregate.entity.User;

public class UserMapper {
    public static User toEntity(CreateUserRequestDTO userDTO) {
        return User.builder()
                .userId(userDTO.getUserId())
                .userPwd(userDTO.getUserPwd())
                .userEmail(userDTO.getUserEmail())
                .userName(userDTO.getUserName())
                .build();
    }
}
