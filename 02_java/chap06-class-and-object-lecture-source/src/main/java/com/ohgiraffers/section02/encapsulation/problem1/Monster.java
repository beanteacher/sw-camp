package com.ohgiraffers.section02.encapsulation.problem1;

public class Monster {
    String name;
    int hp;

    /* setHp라는 메소드를 이용해 필드에 간접 접근하도록 한다. */
    public void setHp(int hp) {
        if(hp > 0) {
            System.out.println("양수 값이 입력 되어 몬스터의 체력을 입력한 값으로 변경한다.");
            /* this : 인스턴스 변수가 생성 되었을 때 자신의 주소를 저장하는 레퍼런스 변수이다. */
            this.hp = hp;
        } else {
            System.out.println("0보다 작거나 같은 값이 입력 되어 몬스터의 체력을 0으로 변경한다.");
            this.hp = 0;
        }
    }
}
