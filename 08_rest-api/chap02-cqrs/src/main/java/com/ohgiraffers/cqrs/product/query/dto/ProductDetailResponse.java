package com.ohgiraffers.cqrs.product.query.dto;

import lombok.Getter;

@Getter
public class ProductDetailResponse {
    private ProductDto product;

    public ProductDetailResponse(ProductDto product) {
        this.product = product;
    }

}
