package com.ohgiraffers.mapping.section01.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberRegistDTO {
    private String memberId;
    private String memberPwd;
    private String memberName;
    private String phone;
    private String address;
    private LocalDateTime enrollDate;
    private MemberRole memberRole;
    private String status;
}
