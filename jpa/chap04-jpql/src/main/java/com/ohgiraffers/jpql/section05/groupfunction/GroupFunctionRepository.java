package com.ohgiraffers.jpql.section05.groupfunction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupFunctionRepository {

    @PersistenceContext
    private EntityManager em;

    public long countMenuOfCategory(int categoryCode) {
        String jpql = "SELECT COUNT(m.menuCode) FROM Section05Menu m WHERE m.categoryCode = :categoryCode";
        long countOfMenu = em.createQuery(jpql, Long.class)
                .setParameter("categoryCode", categoryCode)
                .getSingleResult();

        return countOfMenu;
    }

    public Long sumMenuPriceOfCategory(int categoryCode) {
        String jpql = "SELECT SUM(m.menuPrice) FROM Section05Menu m WHERE m.categoryCode = :categoryCode";
        /* Count 이외의 그룹 함수는 결과 값이 없을 경우 null 이 반환되기 때문에
        * 기본 자료형으로 다룰 경우 문제가 발생한다. Wrapper 클래스 자료형으로 다루어 null 처리가 되도록 처리한다. */
        Long priceOfMenu = em.createQuery(jpql, Long.class)
                .setParameter("categoryCode", categoryCode)
                .getSingleResult();

        return priceOfMenu;
    }

    public List<Object[]> selectByGroupByHaving(long minPrice) {
        String jpql = "SELECT m.categoryCode, SUM(m.menuPrice) FROM Section05Menu m " +
                "GROUP BY m.categoryCode HAVING SUM(m.menuPrice) >= :minPrice";
        return em.createQuery(jpql).setParameter("minPrice", minPrice).getResultList();
    }
}
