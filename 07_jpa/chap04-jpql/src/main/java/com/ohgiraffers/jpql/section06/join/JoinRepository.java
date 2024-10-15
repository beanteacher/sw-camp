package com.ohgiraffers.jpql.section06.join;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JoinRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Menu> selectByInnerJoin() {
        String jpql = "SELECT m FROM Section06Menu m JOIN m.category c";
        return em.createQuery(jpql, Menu.class).getResultList();
    }

    public List<Menu> selectByFetchJoin() {
        /* FETCH : JPQL에서 성능 최적화를 위해 사용하는 기능으로 연관된
        * 엔터티나 컬렉션을 한 번에 조회한다. (지연로딩이 아닌 즉시로딩을 수행한다.) */
        String jpql = "SELECT m FROM Section06Menu m JOIN FETCH m.category c";
        return em.createQuery(jpql, Menu.class).getResultList();
    }

    public List<Object[]> selectByOuterJoin() {
        String jpql = "SELECT m.menuName, c.categoryName FROM Section06Menu m RIGHT JOIN m.category c";
        return em.createQuery(jpql).getResultList();
    }

    public List<Object[]> selectByCollectionJoin() {
        String jpql = "SELECT  c.categoryName, m.menuName FROM Section06Category c LEFT JOIN c.menuList m";
        return em.createQuery(jpql).getResultList();
    }

    public List<Object[]> selectByThetaJoin() {
        String jpql = "SELECT  c.categoryName, m.menuName FROM Section06Category c, Section06Menu m";
        return em.createQuery(jpql).getResultList();
    }
}
