package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedId;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LikeRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Like like) {
        em.persist(like);
    }
}
