package com.ohgiraffers.cqrs.product.command.application.service;

import com.ohgiraffers.cqrs.exception.NotFoundException;
import com.ohgiraffers.cqrs.product.command.application.dto.ProductCreateRequest;
import com.ohgiraffers.cqrs.product.command.application.dto.ProductUpdateRequest;
import com.ohgiraffers.cqrs.product.command.domain.aggregate.Product;
import com.ohgiraffers.cqrs.product.command.domain.aggregate.ProductStatus;
import com.ohgiraffers.cqrs.product.command.domain.repository.ProductRepository;
import com.ohgiraffers.cqrs.product.command.mapper.ProductMapper;
import com.ohgiraffers.cqrs.util.FileUploadUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ProductCommandService {

    @Value("${image.image-url}")
    private String IMAGE_URL;
    @Value("${image.image-dir}")
    private String IMAGE_DIR;

    private final ProductRepository productRepository;

    /* 상품 등록 */
    @Transactional
    public Long createProduct(ProductCreateRequest productRequest, MultipartFile productImg) {

        /* 전달 된 파일을 서버의 지정 경로에 저장 */
        String replaceFileName = FileUploadUtils.saveFile(IMAGE_DIR, productImg);

        /* dto to entity */
        Product newProduct = ProductMapper.toEntity(productRequest, IMAGE_URL + replaceFileName);

        /* save */
        Product product = productRepository.save(newProduct);

        return product.getProductCode();
    }


    /* 상품 수정 */
    @Transactional
    public void updateProduct(Long productCode, ProductUpdateRequest productRequest, MultipartFile productImg) {

        Product product = productRepository.findById(productCode)
                .orElseThrow(() -> new NotFoundException("해당 코드에 맞는 상품이 없습니다. code : " + productCode));

        /* 이미지 수정이 필요할 경우 새로운 이미지 저장 후 기존 이미지 삭제 */
        if(productImg != null) {
            String replaceFileName = FileUploadUtils.saveFile(IMAGE_DIR, productImg);
            FileUploadUtils.deleteFile(IMAGE_DIR, product.getProductImageUrl().replace(IMAGE_URL, ""));
            product.changeProductImageUrl(IMAGE_URL + replaceFileName);
        }

        /* 수정을 위해 엔터티 정보 변경 */
        product.updateProductDetails(
                productRequest.getProductName(),
                productRequest.getProductPrice(),
                productRequest.getProductDescription(),
                productRequest.getCategoryCode(),
                productRequest.getProductStock(),
                ProductStatus.valueOf(productRequest.getStatus())
        );
    }

    /* 상품 삭제 */
    @Transactional
    public void deleteProduct(Long productCode) {
        /* soft delete 될 수 있도록 entity에 설정함 */
        productRepository.deleteById(productCode);
    }
}
