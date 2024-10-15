package com.ohgiraffers.userservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserInfoResponse {
    private String userId;
    private String email;
    private String name;
    private List<OrderInfoResponse> orderInfoResponseList;
}
