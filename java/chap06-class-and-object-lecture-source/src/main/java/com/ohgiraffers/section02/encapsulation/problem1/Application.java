package com.ohgiraffers.section02.encapsulation.problem1;

public class Application {
    public static void main(String[] args) {
        /* 필드에 직접 접근하는 경우 발생할 수 있는 문제점을 이해한다. */
        Monster monster1 = new Monster();
        monster1.name = "두치";
        monster1.hp = 200;
        System.out.println("monster1.name: " + monster1.name);
        System.out.println("monster1.hp: " + monster1.hp);

        Monster monster2 = new Monster();
        monster2.name = "뿌꾸";
        monster2.hp = -200;
        System.out.println("monster2.name: " + monster2.name);
        System.out.println("monster2.hp: " + monster2.hp);

        /* hp는 음수일 수 없음 => 필드에 올바르지 않은 값이 들어가도 통제 불가능하다는 점이 직접 접근의 문제점이다.
        * setHp 메소드로 간접접근 해본다.
        * */
        Monster monster3 = new Monster();
        monster3.name = "프랑켄슈타인";
        monster3.setHp(-200);
        System.out.println("monster3.name: " + monster3.name);
        System.out.println("monster3.hp: " + monster3.hp);

    }
}
