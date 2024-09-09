package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;

public class EntityLifeCycle {
    private EntityManager entityManager;

    public Menu findMenuByMenuCode(int menuCode) {
        entityManager = EntityManagerGenerator.getEntityManager();
        return entityManager.find(Menu.class, menuCode);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
