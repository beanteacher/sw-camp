package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class CartDTO {
    private int cartOwnerMemberNo;
    private int addedBookNo;
    private int quantity;

}
