package com.ohgiraffers.common;

import lombok.*;

@Getter
@Setter
@ToString
// 필드에 final이 붙은 애들만 아규먼트로 생성하는 생성자
// -> @RequiredArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private int seq;
    private String id;
    private String pwd;
    private String name;

}
