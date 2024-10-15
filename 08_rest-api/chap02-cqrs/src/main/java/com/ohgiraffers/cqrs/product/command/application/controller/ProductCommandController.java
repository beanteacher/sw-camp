package com.ohgiraffers.cqrs.product.command.application.controller;

import com.ohgiraffers.cqrs.product.command.application.dto.ProductCreateRequest;
import com.ohgiraffers.cqrs.product.command.application.dto.ProductUpdateRequest;
import com.ohgiraffers.cqrs.product.command.application.service.ProductCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductCommandController {

    private final ProductCommandService productCommandService;

    /* 상품 등록 */
    @PostMapping("/products")
    public ResponseEntity<Void> createProduct(
            /* MultipartFile과 JSON을 동시에 전송하는 방법 */
            @RequestPart @Valid ProductCreateRequest productRequest,
            @RequestPart MultipartFile productImg
    ) {

        Long productCode = productCommandService.createProduct(productRequest, productImg);

        return ResponseEntity
                .created(URI.create("/api/v1/products/" + productCode))
                .build();
    }

    /* 상품 수정 */
    @PutMapping("/products/{productCode}")
    public ResponseEntity<Void> updateProduct(
            @PathVariable Long productCode,
            @RequestPart @Valid ProductUpdateRequest productRequest,
            @RequestPart(required = false) MultipartFile productImg
    ) {

        productCommandService.updateProduct(productCode, productRequest, productImg);

        return ResponseEntity.created(URI.create("/api/v1/products/" + productCode)).build();

    }

    /* 상품 삭제 */
    @DeleteMapping("/products/{productCode}")
    public ResponseEntity<Void> deleteProduct(@PathVariable final Long productCode) {

        productCommandService.deleteProduct(productCode);

        return ResponseEntity.noContent().build();
    }
}
