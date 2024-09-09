package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerGenerator {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaTest");

    private EntityManagerGenerator() {}

    public static EntityManager getEntityManager() { return factory.createEntityManager(); }
}
