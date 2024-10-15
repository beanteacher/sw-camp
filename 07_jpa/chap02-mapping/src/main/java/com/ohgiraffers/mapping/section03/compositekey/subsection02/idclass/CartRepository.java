package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Cart cart) {
        em.persist(cart);
    }
}
