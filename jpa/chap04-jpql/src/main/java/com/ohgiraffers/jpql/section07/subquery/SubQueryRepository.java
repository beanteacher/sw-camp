package com.ohgiraffers.jpql.section07.subquery;

import com.ohgiraffers.jpql.section03.projection.MenuInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubQueryRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Menu> selectWithSubQuery(String categoryName) {
        String jpql = "SELECT m FROM Section07Menu m WHERE m.categoryCode = (" +
                "SELECT c.categoryCode FROM Section07Category c WHERE c.categoryName = :categoryName)";

        return em.createQuery(jpql, Menu.class).setParameter("categoryName", categoryName).getResultList();

    }
}