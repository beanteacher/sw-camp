package com.ohgiraffers.chap06.menu.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="tbl_menu")
@Getter
/* Setter 지양 : 객체를 언제든지 변경할 수 있는 상태가 되므로 객체의 안정성이 보장 받기 힘들다.
* 값 변경이 필요한 경우 ? 해당 기능을 수행하는 명확한 목적의 메소드를 정의하여 사용한다. */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
/* 기본 생성자 접근 제한을 통해 무분별한 객체 생성 지양
* @AllArgsConstructor 지양 : 인스턴스 생성 순어세 영향을 받으므로 변수 순서 변경 시 생성자 입력 값 순서도 바껴
* 검출하기 힘든 오류 발생 가능성이 있다. */
/* @ToString : 사용 시 연관관계 매핑 필드는 제거한다. */
@ToString
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    public void modifyMenuName(String menuName) {
        this.menuName = menuName;
    }
}
