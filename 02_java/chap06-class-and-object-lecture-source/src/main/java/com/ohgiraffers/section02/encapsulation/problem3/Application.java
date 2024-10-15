package com.ohgiraffers.section02.encapsulation.problem3;

public class Application {
    public static void main(String[] args) {
        /* 필드에 직접 접근하는 경우 발생할 수 있는 문제점을 이해한다. */

        /* Monster 클래스 내부에서는 유지보수하면서 코드 변경이 일어나지만
        * 사용자의 호출 코드에서는 변경이 필요 없다. 따라서 유지 보수성이 향상 된다.
        * */
        Monster monster1 = new Monster();
        monster1.setInfo("두치");
        System.out.println("monster1 info: " + monster1.getInfo());

        Monster monster2 = new Monster();
        monster2.setInfo("뿌꾸");
        System.out.println("monster2 info: " + monster2.getInfo());

        /* ----------------------------------------------------------- */
        monster2.kinds = "프랑켄슈타인";
        monster2.hp = -200;
        // => 메소드를 통해 간접 접근하는 방법을 만들었지만 여전히 직접 접근이 가능하므로
        // 직접 접근 불가 강제화 처리가 필요하다.



    }
}
