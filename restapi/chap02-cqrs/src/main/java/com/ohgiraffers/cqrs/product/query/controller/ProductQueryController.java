package com.ohgiraffers.cqrs.product.query.controller;

import com.ohgiraffers.cqrs.product.query.dto.ProductDetailResponse;
import com.ohgiraffers.cqrs.product.query.dto.ProductListResponse;
import com.ohgiraffers.cqrs.product.query.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductQueryController {

    private final ProductQueryService productQueryService;

    @GetMapping("/products")
    public ResponseEntity<ProductListResponse> getProducts(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) Long categoryCode,
            @RequestParam(required = false) String productName
    ) {

        ProductListResponse response = productQueryService.getProducts(page, size, categoryCode, productName);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/products/{productCode}")
    public ResponseEntity<ProductDetailResponse> getProduct(@PathVariable Long productCode) {

        ProductDetailResponse response = productQueryService.getProduct(productCode);

        return ResponseEntity.ok(response);
    }

}
