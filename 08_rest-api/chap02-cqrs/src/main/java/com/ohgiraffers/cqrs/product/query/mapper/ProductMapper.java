package com.ohgiraffers.cqrs.product.query.mapper;

import com.ohgiraffers.cqrs.product.query.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductDto> selectProducts(@Param("offset") int offset, @Param("limit") int limit, @Param("categoryCode") Long categoryCode, @Param("productName") String productName);

    ProductDto selectProductByCode(@Param("productCode") Long productCode);

    long countProducts(@Param("categoryCode") Long categoryCode, @Param("productName") String productName);
}
