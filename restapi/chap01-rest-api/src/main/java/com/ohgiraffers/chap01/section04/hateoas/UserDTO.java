package com.ohgiraffers.chap01.section04.hateoas;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    private int no;
    private String id;
    private String pwd;
    private String name;
    private Date enrollDate;

}
