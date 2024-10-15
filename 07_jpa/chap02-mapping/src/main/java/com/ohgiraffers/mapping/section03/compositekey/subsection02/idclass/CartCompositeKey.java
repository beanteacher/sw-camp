package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class CartCompositeKey implements Serializable {
    private int cartOwner;
    private int addedBook;
}
