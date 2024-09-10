package com.ohgiraffers.associationmapping.section02.onetomany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OneToManyMenuRepository {

    @PersistenceContext
    private EntityManager em;

    public Category find(int categoryCode) {
        return em.find(Category.class, categoryCode);
    }
}
