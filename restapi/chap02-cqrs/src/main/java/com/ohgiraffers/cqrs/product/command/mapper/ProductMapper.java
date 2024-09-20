package com.ohgiraffers.cqrs.product.command.mapper;

import com.ohgiraffers.cqrs.product.command.application.dto.ProductCreateRequest;
import com.ohgiraffers.cqrs.product.command.domain.aggregate.Product;

public class ProductMapper {
    public static Product toEntity(ProductCreateRequest productRequest, String imageUrl) {
        return Product.create(
                productRequest.getProductName(),
                productRequest.getProductPrice(),
                productRequest.getProductDescription(),
                productRequest.getCategoryCode(),
                imageUrl,
                productRequest.getProductStock()
        );
    }
}
