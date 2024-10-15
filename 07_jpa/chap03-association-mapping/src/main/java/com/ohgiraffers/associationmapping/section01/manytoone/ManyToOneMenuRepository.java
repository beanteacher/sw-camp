package com.ohgiraffers.associationmapping.section01.manytoone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ManyToOneMenuRepository {
    @PersistenceContext
    private EntityManager em;

    public Menu find(int menuCode) {
        return em.find(Menu.class, menuCode);
    }
    public String findCategoryName(int menuCode) {

        String jpql = "SELECT c.categoryName " +
                "FROM section01Menu m " +
                "JOIN m.category c " +
                "WHERE m.menuCode = :menuCode";

        return em.createQuery(jpql, String.class).setParameter("menuCode", menuCode).getSingleResult();
    }

    public void regist(Menu menu) {
        em.persist(menu);
    }
}
