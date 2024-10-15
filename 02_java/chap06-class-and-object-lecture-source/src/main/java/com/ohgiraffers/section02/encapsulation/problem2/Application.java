package com.ohgiraffers.section02.encapsulation.problem2;

public class Application {
    public static void main(String[] args) {
        /* 필드에 직접 접근하는 경우 발생할 수 있는 문제점을 이해한다. */

        /* 필드의 변경이 발생하면 사용한 쪽의 코드를 모두 수정해야 한다.
        * 이는 유지 보수에 악영향을 끼친다.
        * */

        Monster monster1 = new Monster();
//        monster1.name = "두치";
        monster1.hp = 200;
//        System.out.println("monster1.name: " + monster1.name);
        System.out.println("monster1.hp: " + monster1.hp);

        Monster monster2 = new Monster();
//        monster2.name = "뿌꾸";
        monster2.hp = -200;
//        System.out.println("monster2.name: " + monster2.name);
        System.out.println("monster2.hp: " + monster2.hp);

    }
}
