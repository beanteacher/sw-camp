package com.ohgiraffers.jpql.section02.parameter;

import com.ohgiraffers.jpql.section01.simple.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParameterRepository {

    @PersistenceContext
    EntityManager em;

    public List<Menu> selectMenuByBindingName(String menuName) {
        String jpql = "SELECT m FROM Section02Menu m WHERE m.menuName = :menuName";
        List<Menu> menuList = em.createQuery(jpql, Menu.class)
                .setParameter("menuName", menuName).getResultList();
        return menuList;
    }

    public List<Menu> selectMenuByBindignPosition(String menuName) {
        String jpql = "SELECT m FROM Section02Menu m WHERE m.menuName = ?1";
        List<Menu> menuList = em.createQuery(jpql, Menu.class)
                .setParameter(1, menuName).getResultList();
        return menuList;
    }
}
