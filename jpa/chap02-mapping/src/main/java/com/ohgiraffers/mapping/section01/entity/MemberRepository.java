package com.ohgiraffers.mapping.section01.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext // EntityManager 자동 의존성 주입
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public String findNameById(String memberId) {
        String jpql = "SELECT m.memberName FROM entityMember m WHERE m.memberId = '" + memberId + "'";

        return em.createQuery(jpql, String.class).getSingleResult();
    }
}