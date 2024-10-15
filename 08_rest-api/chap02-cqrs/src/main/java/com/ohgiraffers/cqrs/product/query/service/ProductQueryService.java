package com.ohgiraffers.cqrs.product.query.service;

import com.ohgiraffers.cqrs.exception.NotFoundException;
import com.ohgiraffers.cqrs.product.query.dto.ProductDetailResponse;
import com.ohgiraffers.cqrs.product.query.dto.ProductDto;
import com.ohgiraffers.cqrs.product.query.dto.ProductListResponse;
import com.ohgiraffers.cqrs.product.query.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
@Transactional(readOnly = true)

성능 최적화:
readOnly 설정을 사용하면 트랜잭션 관리자가 해당 트랜잭션이 읽기 전용임을 인식하고,
불필요한 잠금이나 다른 부하를 줄일 수 있음. 이는 데이터베이스의 성능을 최적화하는 데 도움

명확한 의도 표현:
코드에서 메소드가 데이터 조회에만 사용됨을 명시적으로 나타내므로,
유지보수 시 코드의 의도를 더 쉽게 이해
*/
@Service
@RequiredArgsConstructor
public class ProductQueryService {

    private final ProductMapper productMapper;

    /* 상품 목록 조회 */
    @Transactional(readOnly = true)
    public ProductListResponse getProducts(Integer page, Integer size, Long categoryCode, String productName) {
        int offset = (page - 1) * size;
        List<ProductDto> products = productMapper.selectProducts(offset, size, categoryCode, productName);

        long totalItems = productMapper.countProducts(categoryCode, productName);

        return ProductListResponse.builder()
                .products(products)
                .currentPage(page)
                .totalPages((int) Math.ceil((double) totalItems / size))
                .totalItems(totalItems)
                .build();
    }

    /* 상품 상세 조회  */
    @Transactional(readOnly = true)
    public ProductDetailResponse getProduct(Long productCode) {
        ProductDto product = productMapper.selectProductByCode(productCode);

        if (product == null) {
            throw new NotFoundException("해당 코드를 가진 상품을 찾지 못했습니다. 상품 코드 : " + productCode);
        }

        return new ProductDetailResponse(product);
    }

}
