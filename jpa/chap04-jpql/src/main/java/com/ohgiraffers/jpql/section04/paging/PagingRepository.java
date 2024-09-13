package com.ohgiraffers.jpql.section04.paging;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PagingRepository {
    @PersistenceContext
    EntityManager em;

    public List<Menu> usingPagingAPI(int offset, int limit) {
        String jpql = "SELECT m FROM Section04Menu m ORDER BY m.menuCode DESC";

        List<Menu> menuList = em.createQuery(jpql, Menu.class)
                .setFirstResult(offset) // 조회를 시작할 위치 (0부터) -> ex. offset 이 10이면 0~9는 뛰어넘고 10부터 조회
                .setMaxResults(limit) // 조회할 데이터의 개수 ex. limit 이 10이면 10~20까지 조회
                .getResultList();
        return menuList;
    }
}