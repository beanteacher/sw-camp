package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {

    public void printAllProductList(List<ProductDTO> allProductList) {

        if(allProductList != null && !allProductList.isEmpty()) {
            allProductList.forEach(System.out::println);
        } else {
            System.out.println("조회 결과 없음");
        }
    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {

        System.out.println("검색 조건 : " + searchCondition.getSearchOption() + " = " + searchCondition.getSearchValue());

        if(productList != null && !productList.isEmpty()) {
            productList.forEach(System.out::println);
        } else {
            System.out.println("조회 결과 없음");
        }
    }

    public void printSuccessMessage(String successCode) {

        switch (successCode) {
            case "select":
                System.out.println("등록된 제품이 존재하지 않습니다.");
            case "regist":
                System.out.println("신규 제품 등록 완료");
            case "modify":
                System.out.println("신규 제품 등록 완료");
            case "delete":
                System.out.println("신규 제품 등록 완료");
        }
    }

    public void printErrorMessage(String errorCode) {
        switch (errorCode) {
            case "select":
                System.out.println("등록된 제품이 존재하지 않습니다.");
            case "regist":
                System.out.println("신규 제품 등록 실패");
            case "modify":
                System.out.println("신규 제품 등록 실패");
            case "delete":
                System.out.println("신규 제품 등록 실패");
        }
    }

}