package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EntityLifeCycleTest {
    private EntityLifeCycle entityLifeCycle;

    @BeforeEach
    void init() {this.entityLifeCycle = new EntityLifeCycle(); }

    @DisplayName("비영속 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2})
    void testTransient(int menuCode) {
        Menu foundMenu = entityLifeCycle.findMenuByMenuCode(menuCode);
        Menu newMenu = new Menu(
                foundMenu.getMenuCode(),
                foundMenu.getMenuName(),
                foundMenu.getMenuPrice(),
                foundMenu.getCategoryCode(),
                foundMenu.getOrderableStatus()
        );

        EntityManager entityManager = entityLifeCycle.getEntityManager();

        assertTrue(entityManager.contains(foundMenu));  // foundMenu는 영속성 컨텍스트에서 관리되는 영속 상태의 객체
        assertFalse(entityManager.contains(newMenu));   // newMenu는 영속성 컨텍스트에서 관리되지 않는 비영속 상태의 객체
    }

    @DisplayName("다른 엔터티 매니저가 관리하는 엔터티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2})
    void testManagedOtherEntityManager(int menuCode) {
        Menu menu1 = entityLifeCycle.findMenuByMenuCode(menuCode);
        Menu menu2 = entityLifeCycle.findMenuByMenuCode(menuCode);
        System.out.println(menu1.hashCode());
        System.out.println(menu2.hashCode());
        assertNotEquals(menu1, menu2);
    }

    @DisplayName("같은 엔터티 매니저가 관리하는 엔터티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2})
    void testManagedSameEntityManager(int menuCode) {
        EntityManager em = EntityManagerGenerator.getEntityManager();
        Menu menu1 = em.find(Menu.class, menuCode);
        Menu menu2 = em.find(Menu.class, menuCode);

        System.out.println(menu1.hashCode());
        System.out.println(menu2.hashCode());

        assertEquals(menu1, menu2);
    }

    @DisplayName("준영속성 detach 테스트")
    @ParameterizedTest
    @CsvSource({"11,1000", "13,1000"})
    void testDetachEntity(int menuCode, int menuPrice) {
        EntityManager em = EntityManagerGenerator.getEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();

        entityTransaction.begin();
        Menu foundMenu = em.find(Menu.class, menuCode);
        // detach : 특정 엔터티만 준영속 상태(영속성 컨텍스트가 관리하던 객체를 관리하지 않는 상태로 만든다.)
        em.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice);
        // flush : 영속성 컨텍스트의 상태를 DB로 내보낸다. 단 commit 하지 않은 상태이므로 rollback 가능하다.
        em.flush();

        assertNotEquals(menuPrice, em.find(Menu.class, menuCode).getMenuPrice());
        entityTransaction.rollback();
    }

    @DisplayName("준영속성 merge 테스트")
    @ParameterizedTest
    @CsvSource({"11,1000", "13,1000"})
    void testDetachAndMerge(int menuCode, int menuPrice) {
        EntityManager em = EntityManagerGenerator.getEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();

        entityTransaction.begin();
        Menu foundMenu = em.find(Menu.class, menuCode);
        em.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice);
        // merge : 파라미터로 넘어온 준영속 엔터티 객체의 식별값으로 1차 캐시에서 엔터티 객체를 조회한다.
        // (없으면 DB 에서 조회하여 1차 캐시에 저장한다.)
        // 조회한 영속 엔터티 객체에 준영속 상태의 엔터티 객체의 값을 병합한 뒤 영속 엔터티 객체ㅔ를 반환한다.
        // 혹은 조회할 수 없는 데이터라면 새로 생성해서 병합한다.
        em.merge(foundMenu);
        em.flush();

        assertEquals(menuPrice, em.find(Menu.class, menuCode).getMenuPrice());
        entityTransaction.rollback();
    }

    @DisplayName("detach 후 merge한 데이터 update 테스트")
    @ParameterizedTest
    @CsvSource({"11, 하양 민트초코죽", "12, 까만 딸기탕후루"})
    void testMergeUpdate(int menuCode, String menuName) {
        EntityManager em = EntityManagerGenerator.getEntityManager();
        Menu foundMenu = em.find(Menu.class, menuCode);
        em.detach(foundMenu);

        foundMenu.setMenuName(menuName);
        Menu refoundMenu = em.find(Menu.class, menuCode);

        em.merge(foundMenu);

        assertEquals(menuName, refoundMenu.getMenuName());
    }

    @DisplayName("detach 후 merge한 데이터 save 테스트")
    @Test
    void testMergeSave() {
        EntityManager em = EntityManagerGenerator.getEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();
        Menu foundMenu = em.find(Menu.class, 20);
        em.detach(foundMenu);

        entityTransaction.begin();
        foundMenu.setMenuName("치약맛 초코 아이스크림");
        foundMenu.setMenuCode(998);
        em.merge(foundMenu);

        entityTransaction.commit();

        assertEquals("치약맛 초코 아이스크림", em.find(Menu.class, 999).getMenuName());
    }

    @DisplayName("준 영속화 clear 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,3})
    void testClearPersistenceContext(int menuCode) {
        EntityManager em = EntityManagerGenerator.getEntityManager();
        Menu foundMenu = em.find(Menu.class, menuCode);

        /* 영속성 컨텍스트를 초기화한다. -> 영속성 컨텍스트 내의 모든 엔터티는 준영속화된다. */
        em.clear();

        Menu expectedMenu = em.find(Menu.class, menuCode);
        assertNotEquals(expectedMenu, foundMenu);
    }

    @DisplayName("준 영속화 close 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,3})
    void testClosePersistenceContext(int menuCode) {
        EntityManager em = EntityManagerGenerator.getEntityManager();
        Menu foundMenu = em.find(Menu.class, menuCode);

        /* close : 영속성 컨텍스트 종료된다. 영속성 컨텍스트 내의 모든 엔터티는 준영속화 된다. */
        em.close();

        assertThrows(IllegalAccessError.class, ()-> em.find(Menu.class, menuCode));
    }

    @DisplayName("영속성 엔터티 삭제 remove 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void testRemoveEntity(int menuCode) {
        EntityManager em = EntityManagerGenerator.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Menu foundMenu = em.find(Menu.class, menuCode);

        transaction.begin();
        /* remove : 엔터티를 영속성 컨텍스트 및 데이터 베이스에서 삭제한다.
        * 단, 트랜잭션을 제어하지 않으면 데이터베이스에 영구 반영되지는 않는다. */
        em.remove(foundMenu);
        em.flush();

        Menu refoundMenu = em.find(Menu.class, menuCode);
    }
}