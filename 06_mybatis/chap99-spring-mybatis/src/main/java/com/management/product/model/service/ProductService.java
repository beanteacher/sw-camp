package com.management.product.model.service;

import com.common.SearchCondition;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class ProductService {

    // * 주석을 지우고 Service 역할에 해당하는 메소드를 작성하세요.

    // 1. 자주 사용할 DAO 객체를 선언하세요.

    public List<ProductDTO> selectAllProductList() {
        SqlSession sqlSession = getSqlSession();

        ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
        List<ProductDTO> menuList = mapper.selectAllProductList();

        sqlSession.close();

        return menuList;
    }

    public List<ProductDTO> selectProductByCondition(SearchCondition searchCondition) {

        SqlSession sqlSession = getSqlSession();
        ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);

        List<ProductDTO> productList = mapper.selectProductByCondition(searchCondition);

        sqlSession.close();

        return productList;
    }

    public boolean registNewProduct(ProductDTO product) {

        SqlSession sqlSession = getSqlSession();
        ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
        //    (조건 1) 화면에서 releaseDate를 0000-00-00 형태로 받아옵니다.
        //            해당 필드에 매핑되는 DB 컬럼 releaseDate가 8byte이므로 '-' 문자를 제거하여 product객체에 setting 하세요.
        //            또한 제품 최초 등록 시 생산여부는 무조건 '생산중(Y)'이고, 판매량은 0이므로 해당 값을 product객체에 setting 하세요.
        product.setReleaseDate(product.getReleaseDate().replace("-", ""));
        int result = mapper.registNewProduct(product);

        sqlSession.close();

        return result > 0;
    }

    public boolean modifyProductInfo(ProductDTO product) {

        SqlSession sqlSession = getSqlSession();
        ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);

        int result = mapper.modifyProductInfo(product);

        sqlSession.close();

        return result > 0;
        // 5. 제품 정보를 수정하는 로직을 작성하세요.
        // 　　아래 작성된 return false 과제 툴 오류를 제거하고자 임의 작성하였으니 지우고 로직을 작성하세요.
    }

    public boolean deleteProduct(Map<String, String> parameter) {

        // 6. 제품 정보를 삭제하는 로직을 작성하세요.
        // 　　아래 작성된 return false 과제 툴 오류를 제거하고자 임의 작성하였으니 지우고 로직을 작성하세요.
        SqlSession sqlSession = getSqlSession();
        ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);

        int result = mapper.deleteProduct(parameter);

        sqlSession.close();

        return result > 0;
    }
}