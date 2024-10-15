package com.ohgiraffers.section02.crud;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCRUD {
    private EntityManager entityManager;

    /* 특정 메뉴 코드로 메뉴를 조회 */
    public Menu findMenuByMenuCode(int menuCode) {
        entityManager = EntityManagerGenerator.getEntityManager();

        return entityManager.find(Menu.class, menuCode);
    }

    public Long saveAndReturnAllCount(Menu menu) {
        entityManager = EntityManagerGenerator.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(menu);

        entityTransaction.commit();

        return getCount(entityManager);

    }

    private Long getCount(EntityManager entityManager) {
        return entityManager    // JPQL 문법 -> 별도의 채텁에서 다룸
                .createQuery("SELECT COUNT(*) FROM Section02Menu", Long.class)
                .getSingleResult();
    }

    /* 3. 메뉴 이름 수정 기능 */
    public Menu modifyMenuName(int menuCode, String menuName){
        entityManager = EntityManagerGenerator.getEntityManager();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        foundMenu.setMenuName(menuName);

        entityTransaction.commit();

        return foundMenu;
    }

    /* 4. 특정 메뉴 코드로 메뉴 삭제하는 기능 */
    public Long removeAndReturnAllCount(int menuCode) {
        entityManager = EntityManagerGenerator.getEntityManager();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.remove(foundMenu);

        entityTransaction.commit();

        return getCount(entityManager);
    }
}
