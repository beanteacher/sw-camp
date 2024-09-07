package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;
import java.util.List;
import java.util.Map;

public class ProductController {

    private final ProductService productService;
    private final ProductPrint productPrint;

    public ProductController() {
        this.productService = new ProductService();
        this.productPrint = new ProductPrint();
    }

    public void selectAllProductList() {

        List<ProductDTO> productList = productService.selectAllProductList();

        if(productList != null && !productList.isEmpty()) {
            productPrint.printAllProductList(productList);
        } else {
            productPrint.printErrorMessage("select");
        }
    }

    public void selectProductByCondition(SearchCondition searchCondition) {

        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);

        if(productList != null && !productList.isEmpty()) {
            productPrint.printProductList(productList, searchCondition);
        } else {
            productPrint.printErrorMessage("select");
        }
    }

    public void registNewProduct(ProductDTO product) {

        boolean result = productService.registNewProduct(product);

        if(result) {
            productPrint.printSuccessMessage("regist");
        } else {
            productPrint.printErrorMessage("regist");
        }
    }

    public void modifyProductInfo(ProductDTO product) {

        boolean result = productService.modifyProductInfo(product);

        if(result) {
            productPrint.printSuccessMessage("modify");
        } else {
            productPrint.printErrorMessage("modify");
        }
    }

    public void deleteProduct(Map<String, String> parameter) {

        boolean result = productService.deleteProduct(parameter);

        if(result) {
            productPrint.printSuccessMessage("delete");
        } else {
            productPrint.printErrorMessage("delete");
        }
    }
}