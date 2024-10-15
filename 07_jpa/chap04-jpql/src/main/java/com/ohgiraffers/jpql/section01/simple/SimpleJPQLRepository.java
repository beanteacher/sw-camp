package com.ohgiraffers.jpql.section01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class SimpleJPQLRepository {
    @PersistenceContext
    private EntityManager em;

    public String selectSingleMenuByTypedQuery() {
        String jpql = "SELECT m.menuName FROM Section01Menu m WHERE m.menuCode = 8";
        TypedQuery<String> query = em.createQuery(jpql, String.class);

        return query.getSingleResult();
    }

    public String selectSingleMenuByQuery() {
        String jpql = "SELECT m.menuName FROM Section01Menu m WHERE m.menuCode = 8";
        Query query = em.createQuery(jpql);
        System.out.println(query);
        return query.toString();
    }

    public Menu selectSingleRowByTypedQuery() {
        String jpql = "SELECT m FROM Section01Menu m WHERE m.menuCode = 8";
        TypedQuery<Menu> query = em.createQuery(jpql, Menu.class);

        return query.getSingleResult();
    }

    public List<Menu> selectByTypedQuery() {
        String jpql = "SELECT m FROM Section01Menu m";
        TypedQuery<Menu> query = em.createQuery(jpql, Menu.class);

        return query.getResultList();
    }

    public List<Integer> selectUsingDistinct() {
        String jpql = "SELECT DISTINCT m.categoryCode FROM Section01Menu m";
        TypedQuery<Integer> query = em.createQuery(jpql, Integer.class);

        return query.getResultList();
    }

    public List<Menu> selectUsingIn() {
        String jpql = "SELECT m FROM Section01Menu m WHERE categoryCode IN (11, 12)";
        TypedQuery<Menu> query = em.createQuery(jpql, Menu.class);
        return query.getResultList();
    }

    public List<Menu> selectUsingLike(String searchName) {
        String jpql = "SELECT m FROM Section01Menu m WHERE menuName LIKE '%"+ searchName + "%'";
        TypedQuery<Menu> query = em.createQuery(jpql, Menu.class);
        return query.getResultList();
    }
}
