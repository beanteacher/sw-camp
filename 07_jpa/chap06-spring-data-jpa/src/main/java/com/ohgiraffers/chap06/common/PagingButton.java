package com.ohgiraffers.chap06.common;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PagingButton {
    private int currentPage;
    private int startPage;
    private int endPage;
}