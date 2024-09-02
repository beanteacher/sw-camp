package com.ohgiraffers.section02.encapsulation.problem4;

public class Application {
    public static void main(String[] args) {
        /* 접근 제한자에 대해 이해하고 직접 필드에 접근 못하게 강제화 할 수 있다. */
        Monster monster1 = new Monster();

        /* 필드에 private 를 이용해 접근을 제한하였으므로 직접 접근 코드는 compile error 발생 */
//        monster1.name = "두치";
//        monster1.hp = 200;

        /* 메소드를 통한 간접 접근만 가능하다. */
        monster1.setInfo("두치");
        monster1.setHp(-200);
        System.out.println(monster1.getInfo());

    }
}
